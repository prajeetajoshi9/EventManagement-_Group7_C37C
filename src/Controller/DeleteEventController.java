/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.EventDao;

import View.DeleteEventView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;


/**
 *
 * @author Rashmi Jha
 */
public class DeleteEventController {

    private final EventDao eventDao = new EventDao();
    private final DeleteEventView deleteEventView;

    public DeleteEventController(DeleteEventView deleteEventView) {
        this.deleteEventView = deleteEventView;
        deleteEventView.deleteEventListener(new DeleteButtonListener());
    }

    public void open() {
        deleteEventView.setVisible(true);
    }

    public void close() {
        deleteEventView.dispose();
    }

    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Delete button clicked");
            String idText = deleteEventView.gettextEditEventId().getText().trim();
            if (idText.isEmpty() || idText.equals("Provide your event id")) {
                JOptionPane.showMessageDialog(deleteEventView, "Please enter a valid Event ID");
                return;

            }
            int editEventId = Integer.parseInt(deleteEventView.gettextEditEventId().getText());
            
            Date selectedDate = deleteEventView.getDateChooser().getDate();
            if (selectedDate != null){
                String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
                System.out.println("Selected Event Date: "+ formattedDate);
            }else{
                System.out.println("No date selected.");
            }

            if (editEventId > 0) {
                boolean result = eventDao.deleteEvent(editEventId);
                if (result) {
                    JOptionPane.showMessageDialog(deleteEventView, "Event deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(deleteEventView, "failed to delete event.Event not found.");
                }

            } else {
                JOptionPane.showMessageDialog(deleteEventView, "Deletion Cancelled.");
            }
        }
    }

}
