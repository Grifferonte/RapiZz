package dao;

import java.util.List;

public interface InterfaceDao<T> {
	T getObject(Integer id);
	void addObject(T obj);
	void upadteObject(T obj);
	void deleteObject(T obj);
}
