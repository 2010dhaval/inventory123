package com.untitle.inventory.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.untitle.inventory.dto.AbstractBaseEntity;

public interface ICommonDAO<T>{
public void saveOrUpdate(T entity);
public List<Map<String,Object>> findListByQueryForDynamicEntity(String hql);
public void deleteById(Long id);
public List<T> findByQuery(String hql,Object values);
public List<T> findByQuery(String hql,Map properyMap);
public List<T> findByNamedQuery(String namedQuery);
public List<T> findByNamedQuery(String namedQuery,Object...values);
public List<T> findByNamedQuery(String namedQuery,Map properyMap);
public List<T> findAllRecords();
public void mergeDynamicEntity(String entityName,Object entityMap);
public List<Map<String,Object>> findByQueryForDynamicEntity(String hql);
public List<Map<String,Object>> findByQueryForDynamicEntity(String hql,Object...values);
public List<Map<String,Object>> findByQueryForDynamicEntity(String hql,Map propertyMap);
public List<Map<String,Object>> findByQueryForDynamicEntityPaginated(String string,int rows,int page);
public Long findCountByQuery(String hql);
public T getById(Class<?> entity,Long id);
public T getById(Class<?> entity,String id);
public int getGridCount(Class<?> entityClass);
List<T> getAll(int start,int limitInt,String sidx,String sord, Map<String,String> searchCond,Class<?> entityClass);

List<T> getAll(int start,int limitInt,String sidx,String sord, Map<String,String> searchCond,Class<?> entityClass, Map<String, String> m1);

List<T> getAll(Class<?> entityClass);






}
