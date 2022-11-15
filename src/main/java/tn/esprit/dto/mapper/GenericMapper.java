package tn.esprit.dto.mapper;



import java.util.List;

public interface GenericMapper<D,E> {
    public D toDto(E c );
    public List<D> toDtoList(List<E> list);
    public E toEntity(D c);
    public List<E> toEntityList(List<D> list);
}
