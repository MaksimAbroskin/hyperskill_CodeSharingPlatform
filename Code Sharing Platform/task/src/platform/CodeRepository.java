package platform;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.JSON.JsonObject;

@Repository
public interface CodeRepository extends CrudRepository<JsonObject, Long> {

}
