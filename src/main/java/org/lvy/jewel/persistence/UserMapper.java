package org.lvy.jewel.persistence;

import java.util.List;

import org.lvy.jewel.component.annotation.Mapper;
import org.lvy.jewel.domain.User;

/**
 * Created by livvy on 15/6/27.
 */
@Mapper
public interface UserMapper {

    List<User> findAllUser();
}
