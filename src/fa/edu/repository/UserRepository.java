package fa.edu.repository;
import fa.edu.pojo.*;

public interface UserRepository {
	POJO_User getProfile(int userID);
}