package pl.aka.gify.model;

import lombok.AllArgsConstructor;
import lombok.Data;
/*
    data- generuje tostring, equals, hashcode,
    gettery i settery i konstruktory z pojedynczymi polami
 */
@AllArgsConstructor     // konstruktor z wszystkimi polami
@Data
public class Gif {
    private Integer id;
    private String name;
    private boolean favorite;
    private Category category;
}
