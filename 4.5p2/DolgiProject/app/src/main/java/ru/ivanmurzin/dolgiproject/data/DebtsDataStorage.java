package ru.ivanmurzin.dolgiproject.data;

import java.util.List;

public interface DebtsDataStorage {
    public void saveData(Debt debt);

    public Debt getData(int id);

    public List<Debt> getAllData();
}
