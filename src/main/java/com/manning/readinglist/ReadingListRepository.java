package com.manning.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 王禹展 wyuzhan@163.com
 * @date 2019/2/12  18:27
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
