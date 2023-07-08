package ru.java.rush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.java.rush.entities.FruitEntity;

import java.util.List;

@Repository//помечаем что этот бин - репозиторий
public interface FruitRepository extends JpaRepository<FruitEntity,Integer> {
//репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<>
//для него необходимо указать с какой сущность он должен работать, у нас это FruitEntity
//и тип данных у поля id данной сущности, у нас это Integer
    @Query("select f.fruitName, p.providerName from  FruitEntity f left join ProviderEntity p on f.providerCode = p.id")
    List<String> joinSting();

    @Query("select f from  FruitEntity f  join ProviderEntity p on f.providerCode = p.id")
    List<FruitEntity> joinFruit();

    @Query(
            value = "select fruit_table.fruit_name, provider_table.provider_name from  fruit_table  join provider_table on fruit_table.provider_code = provider_table.id_provider",  //по идее эту портянку надо засунуть в какой нибудь  Enum
            nativeQuery = true) //нужно только пометить только nativeQuery = true
    List<String> joinSqlFruit();
}