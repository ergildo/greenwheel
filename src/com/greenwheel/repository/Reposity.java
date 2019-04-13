package com.greenwheel.repository;

import java.io.Serializable;
import java.util.List;

public interface Reposity<T extends Serializable, ID extends Serializable> {

	public void save(T entity) throws Exception;

	public T get(ID id) throws Exception;

	public List<T> list() throws Exception;
}
