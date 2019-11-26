/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * user defined container
 * credits: https://stackoverflow.com/questions/14758313/filtering-jlist-based-on-jtextfield 
 * @author sven
 *
 */
public class PersonListModel extends AbstractListModel<Person> implements ListDataListener{
	
	public static interface Filter {
        boolean accept(Person element);
    }

	/**
	 * base data container
	 */
	private List<Person> source = null;
	
    private Filter filter;
    private final List<Integer> indices = new ArrayList<Integer>();

	/**
	 * using ternary expressions --> (if ? then : else)
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return (filter != null) ? indices.size() : source.size();
	}

	@Override
	public Person getElementAt(int index) {
		// TODO Auto-generated method stub
		return (filter != null) ? source.get(indices.get(index)) : source.get(index);
	}
	
	/**
	 * ctor
	 * @param source
	 */
	public PersonListModel(List<Person> source) {
        if (source == null)
            throw new IllegalArgumentException("Source is null");
        this.source = source;
    }
	
	public void intervalRemoved(ListDataEvent e) {
        doFilter();
    }

    public void intervalAdded(ListDataEvent e) {
        doFilter();
    }

    public void contentsChanged(ListDataEvent e) {
        doFilter();
    }


	/**
	 * convenience ctor
	 */
	public PersonListModel() {
		this(new LinkedList<Person>());
	}

	/**
	 * sets filter instance
	 * @param f
	 */
	public void setFilter(Filter f) {
        filter = f;
        doFilter();
    }

	/**
	 * filter fun, populates valid index list based on filter interface and source data structure
	 */
    private void doFilter() {
        indices.clear();

        if (this.filter != null) {
	    	for (ListIterator<Person> it = source.listIterator(); it.hasNext();){
	    		if (filter.accept(it.next())) {
	    			indices.add(it.previousIndex());
	    		}
	    	}
	    	
	        fireContentsChanged(this, 0, getSize() - 1);
        }
    }

    /**
     * adds a new person
     * @param p
     */
	public void addElement(Person p) {
		source.add(p);	
		fireContentsChanged(this, 0, getSize());
	}
}
