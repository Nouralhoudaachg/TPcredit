package dao;

public interface IDao<T,Id> {
   T trouverParId(Id id);
}
