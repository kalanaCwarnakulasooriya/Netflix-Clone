package lk.ijse.backend.service;

import lk.ijse.backend.entity.MyList;
import org.springframework.data.domain.Page;

public interface MyListService {
    String addMyList(String userId, String movieId);
    String removeMyList(String userId, String id);
    Page<MyList> getMyList(String userId, int page, int size);
}
