package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.JSON.JsonObject;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class CodeService {

    @Autowired
    private CodeRepository codeRepository;

    public JsonObject findById(Long id) {
        Optional<JsonObject> optional = codeRepository.findById(id);
        return optional.orElse(null);
    }

    public JsonObject[] findLatest() {
        List<JsonObject> list = (List<JsonObject>) codeRepository.findAll();
        LinkedList<JsonObject> result = new LinkedList<>();
        ListIterator<JsonObject> iterator = list.listIterator(list.size());

        for (int i = 10; i > 0; i--) {
            if (!iterator.hasPrevious()) {
                break;
            }
            result.add(iterator.previous());
        }
        return result.toArray(new JsonObject[0]);
    }

    public Long createNote(JsonObject jsonObject) {
        jsonObject.setId(codeRepository.count() + 1);
        return codeRepository.save(jsonObject).getId();
    }

    public String clearDB() {
        codeRepository.deleteAll();
        return "DB cleared";
    }

}
