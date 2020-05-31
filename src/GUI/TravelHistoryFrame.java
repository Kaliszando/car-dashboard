package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Car;
import Data.Travel;

/**
 * Klasa reprezentuje okienko dialogowe historii podr�y.
 * 
 * @version 1.0
 * @author Adam Kalisz
 * @author Kamil Rojszczak
 * 
 */
public class TravelHistoryFrame extends JFrame implements ActionListener {

	private JButton JBupdate, JBremoveEmpty;
	
	/**
	 * Tworzy okno podr�y oraz dodaje rekordy zapisane w bazie danych.
	 * @param title tytu� okienka dialogowego
	 * @param car obiekt klasy Car
	 */
	public TravelHistoryFrame(String title, Car car) {
		super(title);
		setLayout(new BorderLayout());
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Distance [km]");
		columnNames.add("Mileage total [km]");
		columnNames.add("Avg. fuel consumption [l/h]");
		columnNames.add("Start date");
		columnNames.add("End date");		
		
		Vector<Vector> data = new Vector<Vector>();
		ArrayList<Travel> travels = null;
		try {
			travels = car.getDb().retrieveTravels();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Travel t : travels) {
			Vector<Object> row = new Vector<Object>();
			row.add(t.getLength());
			row.add(t.getMileage());
			row.add(t.getAvgFuelConsumption());
			row.add(t.getStartDateString());
			row.add(t.getEndDateString());
			data.add(row);
		}
		
		JTable table = new JTable(data, columnNames);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	// TODO
	/**
	 * Aktualizuje tabel� historii podr�y z bazy danych.
	 */
	public void updateTable() {
		
	}
	
	// TODO
	/**
	 * Obs�uga zdarze� przycisk�w i wywo�anie metod im przypisanym.
	 * @param e powsta�e zdarzenie
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}