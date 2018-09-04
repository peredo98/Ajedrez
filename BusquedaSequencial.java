import java.util.LinkedList;

public class BusquedaSequencial<T>{

	public BusquedaSequencial(){

	}

	public T busquedaSequencial(T [] t, T a){
		for(int i = 0 ; i<t.length; i++){
			if(a == t[i]){
				return t[i];
			}
		}
		return null;
	}
	public T busquedaSequencial(LinkedList<T> t, T a){
		for(int i = 0 ; i<t.size(); i++){
			if(a == t.get(i)){
				return t.get(i);
			}
		}
		return null;
	}
}