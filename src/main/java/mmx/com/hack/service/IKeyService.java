package mmx.com.hack.service;

import mmx.com.hack.domain.UserDetails;

public interface IKeyService {

	public long validateAndFetchKeyId(UserDetails userDetails, String appPackageName) throws Exception;
}
