package noPackage;

import java.io.*;
import java.util.List;

import noPackage.Person;
import noPackage.FileManager;

public class FamilyTreeFileManager<T extends Person> implements FileManager<FamilyTree<T>> {

    // Метод для сохранения объекта FamilyTree в файл
    @Override
    public void saveFamilyTreeToFile(FamilyTree<T> familyTree, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }

    // Метод для загрузки объекта FamilyTree из файла
    @Override
    public FamilyTree<T> loadFamilyTreeFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }

    // Метод для сохранения списка объектов Person в файл
    @Override
    public void savePersonsToFile(List<Person> persons, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(persons);
        }
    }

    // Метод для загрузки списка объектов Person из файла
    @Override
    public List<Person> loadPersonsFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Person>) ois.readObject();
        }
    }
}
