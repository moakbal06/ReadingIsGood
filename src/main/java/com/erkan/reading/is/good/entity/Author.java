package com.erkan.reading.is.good.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    @Id
    @SequenceGenerator(schema = "EKO", name = "seqRigAuthorId", sequenceName = "seq_rig_author_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigAuthorId")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
