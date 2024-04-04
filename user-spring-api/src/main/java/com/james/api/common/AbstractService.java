package com.james.api.common;
import com.james.api.user.User;
import com.james.api.common.component.MessengerVo;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService <T> {


    public abstract List<T> findAll() throws SQLException;

    public abstract Optional<T> findById(long id); // id = 머신이 사용하는 숫자 아이디

    public abstract String count();

    public  abstract  Optional<T> getOne(String id); // id = 사람이 쓰는 영문 아이디



    public  abstract  String deleteAll();

    public  abstract  Boolean existsById(long id);


    public abstract MessengerVo insertMenuData(User user) throws SQLException;
    public  abstract  String delete(T t);
    public abstract MessengerVo save (T t);
}
