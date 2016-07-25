package org.lvy.jewel.persistence;

import org.lvy.jewel.component.annotation.Mapper;
import org.lvy.jewel.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by livvy on 15/6/27.
 */
@Mapper
public interface UserMapper {

    List<User> findAllUser();
}
