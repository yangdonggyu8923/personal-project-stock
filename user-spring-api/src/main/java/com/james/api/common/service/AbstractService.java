package com.james.api.common.service;
import com.james.api.user.model.User;
import com.james.api.common.component.Messenger;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService <T> {


    public abstract List<T> findAll() throws SQLException;

    public abstract Optional<T> findById(long id); // id = 머신이 사용하는 숫자 아이디

    public abstract String count();


    public  abstract  String deleteAll();

    public  abstract  Boolean existsById(long id);


    public abstract Messenger insertMenuData(User user) throws SQLException;
    public  abstract  String delete(T t);
    public abstract Messenger save (T t);
}
