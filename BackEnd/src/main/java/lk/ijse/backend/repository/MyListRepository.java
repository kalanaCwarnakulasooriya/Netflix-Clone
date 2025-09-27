package lk.ijse.backend.repository;

import lk.ijse.backend.entity.MyList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyListRepository extends JpaRepository<MyList, String> {
    Page<MyList> findAllByUserId(String userId, Pageable pageable);

    void deleteById(String id);
}
