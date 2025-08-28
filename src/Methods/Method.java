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
    
    public boolean add(T t) throws Exception;
    
    public boolean update(T t)throws Exception;
    
    public boolean delete(T t)throws Exception;
    
    public T search(Object id)throws Exception;
    
}
