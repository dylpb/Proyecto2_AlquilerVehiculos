/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Methods;

/**
 *
 * @author Dylan
 * @param <T>
 */
public interface Method<T> {
    
    public boolean add(T t);
    
    public boolean update(T t);
    
    public boolean delete(T t);
    
    public T search(Object id);
    
}
