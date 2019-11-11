
package org.opencps.api.controller.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.opencps.api.dossierlog.model.DossierLogModel;
import org.opencps.api.dossierlog.model.DossierLogSearchIdModel;
import org.opencps.auth.utils.APIDateTimeUtils;
import org.opencps.dossiermgt.action.util.ConstantUtils;
import org.opencps.dossiermgt.action.util.ReadFilePropertiesUtils;
import org.opencps.dossiermgt.constants.DossierLogTerm;
import org.opencps.dossiermgt.model.DossierLog;

public class DossierLogUtils {

	public static List<DossierLogModel> mappingToDossierLogData(List<DossierLog> dossierLogs) {

		List<DossierLogModel> outputs = new ArrayList<DossierLogModel>();

		for (DossierLog dossierLog : dossierLogs) {

			DossierLogModel model = mappingToDossierLogModel(dossierLog);

			outputs.add(model);
		}

		return outputs;
	}

	public static DossierLogModel mappingToDossierLogModel(DossierLog dossierLog) {

		if (dossierLog == null) {
			return null;
		}
		DossierLogModel model = new DossierLogModel();

		model.setCreateDate(APIDateTimeUtils.convertDateToString(dossierLog.getCreateDate()));
		model.setNotificationType(dossierLog.getNotificationType());
		model.setAuthor(dossierLog.getAuthor());
		model.setContent(dossierLog.getContent());
		model.setPayload(dossierLog.getPayload());
		model.setDossierLogId(dossierLog.getDossierId());

		return model;
	}

	public static List<DossierLogModel> mappingToDossierLogResultsModel(List<Document> documents) {

		List<DossierLogModel> outputs = new ArrayList<DossierLogModel>();

		for (Document document : documents) {

			DossierLogModel model = new DossierLogModel();

			long dossierLogId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
			long dossierId = GetterUtil.getLong(document.get(DossierLogTerm.DOSSIER_ID));
			int counter = GetterUtil.getInteger(document.get(DossierLogTerm.COUNTER));

			model.setDossierLogId(dossierLogId);
			
			String strDate = document.get(DossierLogTerm.CREATE_DATE);
			
			Date date = null;
			
			if (Validator.isNotNull(strDate)) {
				date = APIDateTimeUtils.convertStringToDate(strDate, ReadFilePropertiesUtils.get(ConstantUtils.PATTERN_LUCENE));
			}
			
			model.setCreateDate(date != null ? APIDateTimeUtils.convertDateToString(date, APIDateTimeUtils._TIMESTAMP): strDate);
			model.setAuthor(document.get(DossierLogTerm.AUTHOR));
			model.setContent(document.get(DossierLogTerm.CONTENT));
			model.setNotificationType(document.get(DossierLogTerm.NOTIFICATION_TYPE));
			model.setPayload(document.get(DossierLogTerm.PAYLOAD));
			model.setDossierId(dossierId);
			model.setServiceCode(document.get(DossierLogTerm.SERVICE_CODE));
			model.setServiceName(document.get(DossierLogTerm.SERVICE_NAME));
			model.setGovAgencyCode(document.get(DossierLogTerm.GOVAGENCYCODE));
			model.setGovAgencyName(document.get(DossierLogTerm.GOVAGENCYNAME));
			model.setCounter(counter);
			outputs.add(model);
		}

		return outputs;
	}
	


	public static List<DossierLogSearchIdModel> mappingToDossierLogSearchByIdResultsModel(List<Document> documents) {

		List<DossierLogSearchIdModel> outputs = new ArrayList<DossierLogSearchIdModel>();

		for (Document document : documents) {

			DossierLogSearchIdModel model = new DossierLogSearchIdModel();

			long dossierLogId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

			model.setDossierLogId(dossierLogId);
			model.setAuthor(document.get(DossierLogTerm.AUTHOR));
			model.setContent(document.get(DossierLogTerm.CONTENT));
			
			String strDate = document.get(DossierLogTerm.CREATE_DATE);
			
			Date date = null;
			
			if (Validator.isNotNull(strDate)) {
				date = APIDateTimeUtils.convertStringToDate(strDate, ReadFilePropertiesUtils.get(ConstantUtils.PATTERN_LUCENE));
			}
			
			model.setCreateDate(date != null ? APIDateTimeUtils.convertDateToString(date, APIDateTimeUtils._TIMESTAMP): strDate);	
			model.setNotificationType(document.get(DossierLogTerm.NOTIFICATION_TYPE));
			model.setPayload(document.get(DossierLogTerm.PAYLOAD));

			outputs.add(model);
		}

		return outputs;

	}
}
