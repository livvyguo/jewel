package org.lvy.jewel.persistence;

import org.lvy.jewel.component.annotation.Mapper;
import org.lvy.jewel.domain.InputResource;

import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 2016/12/1.
 */
@Mapper
public interface InputResourceMapper {

    List<InputResource> selectInputResources();
}
