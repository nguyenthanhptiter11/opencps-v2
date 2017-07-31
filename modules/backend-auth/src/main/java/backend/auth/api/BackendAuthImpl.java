package backend.auth.api;

import java.util.List;

import org.mobilink.backend.activity.model.Activity;
import org.mobilink.backend.activity.model.Participant;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

public class BackendAuthImpl implements BackendAuth {

	@Override
	public boolean isAuth(ServiceContext context, String security, String password) {

		boolean isAuth = false;

		if (Validator.isNotNull(security)) {

			Activity activity = BackendUtils.getActivity(security);

			if (Validator.isNotNull(activity)) {

				Participant participant = BackendUtils.getParticipant(activity.getActivityId(), password);

				if (Validator.isNotNull(participant)) {
					isAuth = true;
				}

			}

		} else {
			isAuth = context.isSignedIn();
		}

		return isAuth;
	}

	@Override
	public boolean hasResource(ServiceContext context, String name, String actionId) {

		boolean hasPermission = false;

		List<Role> roles = RoleLocalServiceUtil.getUserRoles(context.getUserId());
		try {
			for (Role role : roles) {
				hasPermission = ResourcePermissionLocalServiceUtil.hasResourcePermission(context.getCompanyId(), name,
						ResourceConstants.SCOPE_INDIVIDUAL, Long.toString(role.getRoleId()), role.getRoleId(),
						actionId);

				if (hasPermission) {
					break;
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return hasPermission;
	}

	Log _log = LogFactoryUtil.getLog(BackendAuthImpl.class);

}
