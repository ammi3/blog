package com.ammi3.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 把博客和标签关系存到数据库中使用的类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndTag implements Serializable {

    private Long tagId;

    private Long blogId;
}
