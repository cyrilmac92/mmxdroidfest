package mmx.com.hack.service;

import mmx.com.hack.domain.UserDetails;

public interface IUtilService {

	public long validateAndFetchUserId(String username, String password) throws Exception;
}
