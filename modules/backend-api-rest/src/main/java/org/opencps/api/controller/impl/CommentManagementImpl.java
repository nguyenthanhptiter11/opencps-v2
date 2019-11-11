
package org.opencps.api.controller.impl;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.opencps.api.comment.model.CommentInputModel;
import org.opencps.api.comment.model.CommentListModel;
import org.opencps.api.comment.model.CommentModel;
import org.opencps.api.comment.model.CommentSearchModel;
import org.opencps.api.comment.model.CommentTopList;
import org.opencps.api.controller.CommentManagement;
import org.opencps.api.controller.util.CommentUtils;
import org.opencps.api.error.model.ErrorMsg;
import org.opencps.datamgt.constants.CommentTerm;
import org.opencps.datamgt.model.Comment;
import org.opencps.datamgt.service.CommentLocalServiceUtil;
import org.opencps.dossiermgt.action.util.ConstantUtils;
import org.opencps.dossiermgt.action.util.ReadFilePropertiesUtils;

import backend.auth.api.exception.BusinessExceptionImpl;

/**
 * @author trungnt
 */
public class CommentManagementImpl implements CommentManagement {

	@Override
	public Response addComment(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext,
			CommentInputModel commentInputModel) {

		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

		long userId = serviceContext.getUserId();

		try {

			Comment comment = CommentLocalServiceUtil.addComment(userId, groupId, commentInputModel.getClassName(),
					commentInputModel.getClassPK(), commentInputModel.getFullname(), commentInputModel.getEmail(),
					commentInputModel.getParent(), commentInputModel.getContent(), 0, null, StringPool.BLANK,
					StringPool.BLANK, 0, commentInputModel.getPings(), commentInputModel.getOpinion(), serviceContext);

			CommentModel commentModel;

			commentModel = CommentUtils.mappingComment(comment, serviceContext);

			return Response.status(200).entity(commentModel).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response addCommentAttachment(Attachment attachment, HttpServletRequest request, HttpHeaders header,
			ServiceContext serviceContext, String className, String classPK, long parent, String fileName,
			String fileType, long fileSize, String pings, String email, String fullname, Boolean opinion) {

		InputStream inputStream = null;

		try {
			DataHandler dataHandler = attachment.getDataHandler();

			long userId = serviceContext.getUserId();

			long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

			inputStream = dataHandler.getInputStream();
			Comment comment = CommentLocalServiceUtil.addComment(userId, groupId, className, classPK, fullname, email,
					parent, StringPool.BLANK, fileSize, inputStream, fileName, fileType, 0, pings, opinion, serviceContext);

			CommentModel commentModel = new CommentModel();

			commentModel = CommentUtils.mappingComment(comment, serviceContext);

			return Response.status(200).entity(commentModel).build();
		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				_log.error(e);
			}
		}
	}

	@Override
	public Response getCommentAttachment(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext,
			long commentId) {

		try {

			Comment comment = CommentLocalServiceUtil.fetchComment(commentId);

			long fileEntryId = comment.getFileEntryId();

			FileEntry fileEntry;

			File file = null;

			fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);

			file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), fileEntry.getVersion(), true);
			
			if(file != null && fileEntry != null){
				String fileName = fileEntry.getFileName();

				ResponseBuilder responseBuilder = Response.ok((Object) file);

				responseBuilder.header(ReadFilePropertiesUtils.get(ConstantUtils.TYPE_DISPOSITON), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_PATTERN_FILENAME) + fileName + "\"")
						.header(ConstantUtils.CONTENT_TYPE, fileEntry.getMimeType());

				return responseBuilder.build();
			}else{
				ErrorMsg error = new ErrorMsg();
				error.setMessage(ReadFilePropertiesUtils.get(ConstantUtils.ERROR_NOT_PERMISSION));
				error.setCode(404);
				error.setDescription(ReadFilePropertiesUtils.get(ConstantUtils.ERROR_NOT_PERMISSION));
				return Response.status(404).entity(error).build();
			}

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}

	}

	@Override
	public Response getCommentList(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext,
			String className, long classPK, CommentSearchModel query) {

		// _Results results = new _Results();

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(serviceContext.getCompanyId());

		Map<String, Object> params = new HashMap<String, Object>();

		Hits hits = null;

		try {

			long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

			if (query.getEnd() == 0) {

				query.setStart(-1);

				query.setEnd(-1);
			}

			params.put(Field.GROUP_ID, String.valueOf(groupId));
			params.put(ConstantUtils.SEARCH_KEYWORD, query.getKeywords());
			params.put(CommentTerm.CLASS_NAME, className);
			params.put(CommentTerm.CLASS_PK, String.valueOf(classPK));
			if (Validator.isNotNull(query.getOpinion())) {
				params.put(CommentTerm.OPINION, query.getOpinion());				
			}
			
			Sort[] sorts = new Sort[] {
					SortFactoryUtil.create(query.getSort() + ReadFilePropertiesUtils.get(ConstantUtils.SORT_PATTERN), Sort.STRING_TYPE, query.isOrder()) };

			hits = CommentLocalServiceUtil.luceneSearchEngine(params, sorts, query.getStart(), query.getEnd(),
					searchContext);

			CommentListModel results = CommentUtils.mappingCommentList(hits.toList(), serviceContext, header, query);

			return Response.status(200).entity(results).build();
		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response removeComment(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext,
			long commentId) {

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(serviceContext.getCompanyId());

		try {

			CommentLocalServiceUtil.deleteComment(commentId);

			JSONObject result = JSONFactoryUtil.createJSONObject();

			result.put(ReadFilePropertiesUtils.get(ConstantUtils.MESSAGE_MSG), ReadFilePropertiesUtils.get(ConstantUtils.STATUS_DONE));

			return Response.status(200).entity(result.toString()).build();
		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response removeUpvoteCount(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext, User user,
			long commentId, CommentInputModel commentInputModel) {

		try {

			String email = commentInputModel.getEmail();

			Comment comment = CommentLocalServiceUtil.updateComment(commentId, commentInputModel.getClassName(),
					commentInputModel.getClassPK(), email, -1, serviceContext);

			CommentModel commentModel;

			commentModel = CommentUtils.mappingComment(comment, serviceContext);

			return Response.status(200).entity(commentModel).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response updateComment(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext, User user,
			long commentId, CommentInputModel commentInputModel) {

		try {
			String email = commentInputModel.getEmail();
			String fullname = commentInputModel.getFullname();

			Comment comment = CommentLocalServiceUtil.updateComment(serviceContext.getUserId(), commentId,
					commentInputModel.getClassName(), commentInputModel.getClassPK(), fullname, email,
					commentInputModel.getParent(), commentInputModel.getContent(), commentInputModel.getPings(),
					serviceContext);

			CommentModel commentModel;

			commentModel = CommentUtils.mappingComment(comment, serviceContext);

			return Response.status(200).entity(commentModel).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response updateUpvoteCount(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext, User user,
			long commentId, CommentInputModel commentInputModel) {

		try {

			String email = commentInputModel.getEmail();

			Comment comment = CommentLocalServiceUtil.updateComment(commentId, commentInputModel.getClassName(),
					commentInputModel.getClassPK(), email, 0, serviceContext);

			CommentModel commentModel;

			commentModel = CommentUtils.mappingComment(comment, serviceContext);

			return Response.status(200).entity(commentModel).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(CommentManagementImpl.class);

	@Override
	public Response getCommentTop(HttpServletRequest request, HttpHeaders header, ServiceContext serviceContext,
			CommentSearchModel query) {

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(serviceContext.getCompanyId());

		try {

			long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

			if (query.getEnd() == 0) {
				query.setStart(-1);
				query.setEnd(-1);
			}

			List<Comment> listComments = new ArrayList<>(CommentLocalServiceUtil.findByF_groupId(groupId, query.getStart(), query.getEnd()));

			Collections.reverse(listComments);
			
			CommentTopList results = CommentUtils.mappingCommentTopList(listComments, serviceContext);

			return Response.status(200).entity(results).build();
			
		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

}
