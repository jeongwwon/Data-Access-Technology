package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<Item,Long> {
        List<Item> findByItemNameLike(String itemName);

        List<Item> findByPriceLessThanEqual(Integer price);

        //쿼리 메서드
        List<Item> findByItemNameLikeAndPriceLessThanEqual(String ItemName,Integer price);

        //쿼리 직접 실행
        @Query(
                "SELECT i FROM Item i " +
                        "WHERE i.itemName LIKE :itemName " +
                        "AND i.price <= :price"
        )
        List<Item> findItems(
                @Param("itemName") String itemName,
                @Param("price") Integer price
        );
}
