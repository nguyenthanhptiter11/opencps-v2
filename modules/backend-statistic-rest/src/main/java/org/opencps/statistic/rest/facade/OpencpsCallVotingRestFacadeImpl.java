package org.opencps.statistic.rest.facade;

import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.util.HashMap;

import org.opencps.statistic.rest.dto.GetVotingResultRequest;
import org.opencps.statistic.rest.dto.GetVotingResultResponse;
import org.opencps.statistic.rest.util.DossierStatisticConfig;
import org.opencps.statistic.rest.util.DossierStatisticConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import opencps.statistic.common.webservice.exception.UpstreamServiceFailedException;
import opencps.statistic.common.webservice.exception.UpstreamServiceTimedOutException;
import opencps.statistic.common.webservice.facade.OpencpsRestFacade;

public class OpencpsCallVotingRestFacadeImpl extends OpencpsRestFacade<GetVotingResultRequest, GetVotingResultResponse>
		implements OpencpsCallRestFacade<GetVotingResultRequest, GetVotingResultResponse> {

	//private final static Log _log = LogFactoryUtil.getLog(OpencpsCallDossierRestFacadeImpl.class);

	@Override
	public GetVotingResultResponse callRestService(GetVotingResultRequest payload)
			throws UpstreamServiceTimedOutException, UpstreamServiceFailedException {
		return makeServiceCall(payload);
	}

/*	@Override
	protected GetDossierResponse makeServiceCall(GetDossierRequest payload)
			throws UpstreamServiceTimedOutException, UpstreamServiceFailedException {
		
		MultiValueMap<String, String> urlQueryParams = new LinkedMultiValueMap<>();
		
		//buildUrlQueryParams(urlQueryParams, payload);
		
		String endPoint = DossierStatisticConfig.get(DossierStatisticConstants.DOSSIER_ENDPOINT);

		//LOG.info(endPoint);

		// get the params for EE
		HashMap<String, String> urlPathSegments = new HashMap<>();

		// build the url
		String url = buildUrl(endPoint, urlPathSegments, urlQueryParams);
		
		//LOG.info(url);

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.add(DossierStatisticConstants.GROUP_ID, Long.toString(payload.getGroupId()));

		return executeGenericRestCall(url, HttpMethod.GET, httpHeaders, payload, GetDossierResponse.class).getBody();

	}*/
	
	protected GetVotingResultResponse makeServiceCall(GetVotingResultRequest payload)
			throws UpstreamServiceTimedOutException, UpstreamServiceFailedException {
		
		MultiValueMap<String, String> urlQueryParams = new LinkedMultiValueMap<>();
		System.out.println("payload.isCalculate(): "+payload.isCalculate());
		if (payload.isCalculate()) {
			if (payload.getMonth() != null) {
				//urlQueryParams.add("month", payload.getMonth());
				urlQueryParams.add("month", "10");
			}
			else {
				urlQueryParams.add("month", Integer.toString(LocalDate.now().getMonthValue()));
			}
			if (payload.getYear() != null) {
				urlQueryParams.add("year", payload.getYear());
			}
			else {
				urlQueryParams.add("year", Integer.toString(LocalDate.now().getYear()));
			}
		} else {
//			if (Validator.isNotNull(payload.getGovAgencyCode())) {
//				urlQueryParams.add("agency", payload.getGovAgencyCode());
//			}
			if (Validator.isNotNull(payload.getFromVotingDate())) {
				urlQueryParams.add("fromVotingDate", payload.getFromVotingDate());
			}
			if (Validator.isNotNull(payload.getToVotingDate())) {
				urlQueryParams.add("toVotingDate", payload.getToVotingDate());
			}
		}

		//urlQueryParams.add("top", "statistic");

		String endPoint = DossierStatisticConfig.get(DossierStatisticConstants.VOTING_ENDPOINT);
		System.out.println("endPoint: "+endPoint);
		HashMap<String, String> urlPathSegments = new HashMap<>();
		String url = buildUrl(endPoint, urlPathSegments, urlQueryParams);
		System.out.println("url: "+url);
		// LOG.info(url);
		HttpHeaders httpHeaders = new HttpHeaders();
		
		//DossierStatisticUtils.logAsFormattedJson(LOG, httpHeaders);
		
		httpHeaders.add("groupId", Long.toString(payload.getGroupId()));
		return (GetVotingResultResponse) this
				.executeGenericRestCall(url, HttpMethod.GET, httpHeaders, payload, GetVotingResultResponse.class).getBody();
	}

}