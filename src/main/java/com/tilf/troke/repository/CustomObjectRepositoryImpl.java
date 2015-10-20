package com.tilf.troke.repository;

import com.tilf.troke.entity.ObjectsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Manu on 2015-10-19.
 */
@Repository
public class CustomObjectRepositoryImpl implements CustomObjectRepository{
    @PersistenceContext
    private EntityManager entityManager;

    // Requêtes sur les catégories
    @Override
    public List<String> getAllCategories()
    {
        String query = "select NAME_CATEGORY from category";
        Query queryObject = entityManager.createNativeQuery(query);
        List<String> categoryList = (List<String>)queryObject.getResultList();

        return categoryList;
    }

    @Override
    public List<String> getAllSubCategories(String categoryName)
    {
        int number = 11;
        //BigInteger bi = BigInteger.valueOf(number);

        String query = "select NAME_SUBCATEGORY from subcategory where IDCATEGORY=:number1";
        Query queryObject = entityManager.createNativeQuery(query);
        number = getIdCategoryFromCategoryName(categoryName);
        queryObject.setParameter("number1", number);

        List<String> subcategoryList = (List<String>)queryObject.getResultList();

        return subcategoryList;
    }

    // Requêtes sur les objects
    @Override
    public List<ObjectsEntity> getRecentItems()
    {
        TypedQuery<ObjectsEntity> query = entityManager.createQuery("select o from ObjectsEntity as o order by o.creationdate desc", ObjectsEntity.class);
        List<ObjectsEntity> objects = query.setMaxResults(36).getResultList();

        return objects;
    }

    @Override
    public List<ObjectsEntity> getObjectsByCategory(String categoryName)
    {
        TypedQuery<ObjectsEntity> query = entityManager.createQuery("select o from ObjectsEntity as o where exists (select s from SubcategoryEntity s where o.idsubcategory=s.idSubcategory and s.idcategory=:idcategory)", ObjectsEntity.class);
        query.setParameter("idcategory", getIdCategoryFromCategoryName(categoryName));
        List<ObjectsEntity> result = query.getResultList();

        return result;
    }

    @Override
    public List<ObjectsEntity> getObjectsBySubCategory(String subCategoryName)
    {
        TypedQuery<ObjectsEntity> query = entityManager.createQuery("select o from ObjectsEntity o where o.idsubcategory=:idsubcategory", ObjectsEntity.class);
        query.setParameter("idsubcategory", getSubCategoryIdBySubCategoryName(subCategoryName));
        List<ObjectsEntity> result = query.getResultList();

        return result;
    }

    public int getSubCategoryIdBySubCategoryName(String subCategoryName)
    {
        String query = "select IDSUBCATEGORY from subcategory s inner join category c on s.idcategory=c.idcategory where NAME_SUBCATEGORY=:name";
        Query queryObject = entityManager.createNativeQuery(query);
        queryObject.setParameter("name", subCategoryName);
        int idsubcategory = (int)queryObject.getSingleResult();

        return idsubcategory;
    }
    public int getIdCategoryFromCategoryName(String categoryName)
    {
        String query = "select distinct c.idcategory from category c inner join subcategory s on c.idcategory=s.idcategory where name_category=:name";
        Query queryObject = entityManager.createNativeQuery(query);
        queryObject.setParameter("name", categoryName);
        int idcategory = (int) queryObject.getSingleResult();
        return idcategory;
    }

    @Override
    public ObjectsEntity getObjectEntityByIdObject(int id_object)
    {
        String query = "select o from ObjectsEntity o where o.idobject=:idobject";
        Query queryObject = entityManager.createQuery(query);
        queryObject.setParameter("idobject", id_object);
        ObjectsEntity obj = (ObjectsEntity) queryObject.getSingleResult();

        return obj;
    }

    // Recherches
    @Override
    public List<ObjectsEntity> getObjectListByKeyword(String keyword)
    {
        String query = "select o from ObjectsEntity o where UPPER(o.nameObject) like UPPER(:keyword)";
        Query queryObject = entityManager.createQuery(query);
        queryObject.setParameter("keyword", "%" + keyword + "%");
        List<ObjectsEntity> objList = (List<ObjectsEntity>) queryObject.getResultList();

        return objList;
    }
}
