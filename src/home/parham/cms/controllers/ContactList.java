package home.parham.cms.controllers;

import home.parham.cms.domain.Contact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContactList implements List<Contact> {

	private ArrayList<Contact> contacts;

	public ContactList() {
		contacts = new ArrayList<>();
	}

	@Override
	public boolean add(Contact contact) {
		return contacts.add(contact);
	}

	@Override
	public void add(int index, Contact contact) {
		contacts.add(index, contact);
	}

	@Override
	public boolean addAll(Collection<? extends Contact> collection) {
		return contacts.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Contact> collection) {
		return contacts.addAll(index, collection);
	}

	@Override
	public void clear() {
		contacts.clear();
	}

	@Override
	public boolean contains(Object object) {
		return contacts.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return contacts.containsAll(collection);
	}

	@Override
	public Contact get(int index) {
		return contacts.get(index);
	}

	@Override
	public int indexOf(Object object) {
		return contacts.indexOf(object);
	}

	@Override
	public boolean isEmpty() {
		return contacts.isEmpty();
	}

	@Override
	public Iterator<Contact> iterator() {
		return contacts.iterator();
	}

	@Override
	public int lastIndexOf(Object object) {
		return contacts.lastIndexOf(object);
	}

	@Override
	public ListIterator<Contact> listIterator() {
		return contacts.listIterator();
	}

	@Override
	public ListIterator<Contact> listIterator(int index) {
		return contacts.listIterator(index);
	}

	@Override
	public boolean remove(Object object) {
		return contacts.remove(object);
	}

	@Override
	public Contact remove(int index) {
		return contacts.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return contacts.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return contacts.retainAll(collection);
	}

	@Override
	public Contact set(int index, Contact contact) {
		return contacts.set(index, contact);
	}

	@Override
	public int size() {
		return contacts.size();
	}

	@Override
	public List<Contact> subList(int fromIndex, int toIndex) {
		return contacts.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return contacts.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return contacts.toArray(array);
	}
}