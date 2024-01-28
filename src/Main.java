import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor: [Name: " + name + ", Specialization: " + specialization + "]";
    }
}

class DoctorAppointment {
    private String patientName;
    private Doctor doctor;
    private String date;

    public DoctorAppointment(String patientName, Doctor doctor, String date) {
        this.patientName = patientName;
        this.doctor = doctor;
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment: [Patient: " + patientName + ", " + doctor + ", Date: " + date + "]";
    }
}

class DoctorAppointmentsManager {
    private ArrayList<DoctorAppointment> appointments;

    public DoctorAppointmentsManager() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(DoctorAppointment appointment) throws Exception {
        // Check for same date appointments based on doctor name and specialization
        for (DoctorAppointment existingAppointment : appointments) {
            if (existingAppointment.getDoctor().getName().equalsIgnoreCase(appointment.getDoctor().getName())
                    && existingAppointment.getDoctor().getSpecialization().equalsIgnoreCase(appointment.getDoctor().getSpecialization())
                    && existingAppointment.getDate().equalsIgnoreCase(appointment.getDate())) {
                throw new Exception("Appointment on the same date with the same doctor is not allowed.");
            }
        }

        appointments.add(appointment);
        System.out.println("Appointment added successfully!");
    }

    public void displayAppointments() {
        System.out.println("All Appointments:");
        for (DoctorAppointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public int searchAppointment(String patientName) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientName().equalsIgnoreCase(patientName)) {
                return i;
            }
        }
        return -1; // Appointment not found
    }

    public void updateAppointment(String patientName, String newDoctorName, String newSpecialization, String newDate) throws Exception {
        int index = searchAppointment(patientName);
        if (index != -1) {
            // Check for same date appointments based on doctor name and specialization
            for (DoctorAppointment existingAppointment : appointments) {
                if (!existingAppointment.getPatientName().equalsIgnoreCase(patientName)
                        && existingAppointment.getDoctor().getName().equalsIgnoreCase(newDoctorName)
                        && existingAppointment.getDoctor().getSpecialization().equalsIgnoreCase(newSpecialization)
                        && existingAppointment.getDate().equalsIgnoreCase(newDate)) {
                    throw new Exception("Appointment on the same date with the same doctor is not allowed.");
                }
            }

            Doctor newDoctor = new Doctor(newDoctorName, newSpecialization);
            appointments.get(index).setDoctor(newDoctor);
            appointments.get(index).getDate();
            System.out.println("Appointment updated successfully!");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void deleteAppointment(String patientName) {
        int index = searchAppointment(patientName);
        if (index != -1) {
            appointments.remove(index);
            System.out.println("Appointment deleted successfully!");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoctorAppointmentsManager appointmentsManager = new DoctorAppointmentsManager();

        while (true) {
            try {
                System.out.println("\n1. Add Appointment");
                System.out.println("2. Display Appointments");
                System.out.println("3. Search Appointment");
                System.out.println("4. Update Appointment");
                System.out.println("5. Delete Appointment");
                System.out.println("6. Exit");
                System.out.println("Enter your choice:");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter patient name:");
                        String patientName = scanner.next();
                        System.out.println("Enter doctor name:");
                        String doctorName = scanner.next();
                        System.out.println("Enter doctor specialization:");
                        String specialization = scanner.next();
                        System.out.println("Enter appointment date:");
                        String date = scanner.next();
                        scanner.nextLine();
                        Doctor doctor = new Doctor(doctorName, specialization);
                        DoctorAppointment newAppointment = new DoctorAppointment(patientName, doctor, date);
                        appointmentsManager.addAppointment(newAppointment);
                        break;

                    case 2:
                        appointmentsManager.displayAppointments();
                        break;

                    case 3:
                        System.out.println("Enter patient name to search:");
                        String searchPatientName = scanner.next();
                        int searchResult = appointmentsManager.searchAppointment(searchPatientName);
                        if (searchResult != -1) {
                            System.out.println("Appointment found: " + appointmentsManager.appointments.get(searchResult));
                        } else {
                            System.out.println("Appointment not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Enter patient name to update:");
                        String updatePatientName = scanner.next();
                        System.out.println("Enter new doctor name:");
                        String newDoctorName = scanner.next();
                        System.out.println("Enter new doctor specialization:");
                        String newSpecialization = scanner.next();
                        System.out.println("Enter new appointment date:");
                        String newDate = scanner.next();

                        appointmentsManager.updateAppointment(updatePatientName, newDoctorName, newSpecialization, newDate);
                        break;

                    case 5:
                        System.out.println("Enter patient name to delete:");
                        String deletePatientName = scanner.next();
                        appointmentsManager.deleteAppointment(deletePatientName);
                        break;

                    case 6:
                        System.out.println("Exiting program.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
