package util; // Asegúrate que el paquete sea correcto para tu proyecto

import core.controllers.flightController.ValidFlightIdFormatController;
import core.controllers.locationController.ValidAirportIdFormatLocationController;
import core.controllers.passengerController.CreatePassengerController; // Usando el nombre de tu archivo
import core.controllers.planeController.ValidPlaneIdFormatController;
import core.controllers.flightController.CreateFlightController;
import core.controllers.locationController.CreateLocationController;
import core.controllers.planeController.CreatePlaneController;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

// Imports para org.json
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Imports para leer desde el sistema de archivos
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException; // Import para IOException

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// Ya no necesitas BufferedReader, InputStream, InputStreamReader, Collectors si solo lees desde el sistema de archivos así.

/**
 * Clase encargada de cargar datos iniciales desde archivos JSON.
 * Utiliza la librería org.json y lee los archivos desde el sistema de archivos.
 * @author JorgeDuarte
 */
public class DataLoader {

    // Nombre de la carpeta JSON relativa a la raíz del proyecto
    private static final String JSON_FOLDER_NAME = "json"; 

    /**
     * Obtiene el contenido de un archivo JSON como String leyéndolo desde el sistema de archivos.
     * Se asume que la carpeta 'json' está en la raíz del directorio del proyecto.
     * @param fileName El nombre del archivo JSON (ej. "locations.json")
     * @return El contenido del archivo como String, o null si no se puede leer.
     */
    private static String getJsonFileContent(String fileName) {
        try {
            // Obtiene la ruta del directorio actual donde se ejecuta el proyecto (debería ser la raíz del proyecto 'Airport')
            Path projectDir = Paths.get("").toAbsolutePath(); 
            // Construye la ruta a tu archivo JSON dentro de la carpeta 'json' en la raíz del proyecto
            Path filePath = projectDir.resolve(JSON_FOLDER_NAME).resolve(fileName);

            System.out.println("Intentando leer archivo desde el sistema de archivos: " + filePath.toString());

            if (Files.exists(filePath) && Files.isReadable(filePath)) {
                // Lee todos los bytes del archivo y los convierte a String
                String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
                System.out.println("ÉXITO: Archivo '" + fileName + "' leído desde: " + filePath.toString());
                return content;
            } else {
                System.err.println("FALLO: Archivo no encontrado o no se puede leer en: " + filePath.toString());
                System.err.println("Asegúrate de que la carpeta '" + JSON_FOLDER_NAME + "' exista en la raíz de tu proyecto (" + projectDir.toString() + ") y contenga el archivo '" + fileName + "'.");
                return null;
            }
        } catch (IOException e) { 
            System.err.println("Error de E/S al leer '" + fileName + "' desde el sistema de archivos: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) { 
            System.err.println("Error inesperado al intentar leer '" + fileName + "': " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void loadInitialData() {
        System.out.println("Iniciando carga de datos iniciales...");
        loadLocations();
        loadPlanes();
        loadPassengers();
        loadFlights();
        System.out.println("Carga de datos iniciales completada.");
    }

    private static void loadLocations() {
        String fileContent = getJsonFileContent("locations.json");
        if (fileContent == null) {
            System.err.println("No se pudo cargar el archivo locations.json.");
            return;
        }
        System.out.println("Cargando ubicaciones...");

        try {
            JSONArray locationsArray = new JSONArray(new JSONTokener(fileContent));
            int count = 0;
            for (int i = 0; i < locationsArray.length(); i++) {
                JSONObject locJson = locationsArray.getJSONObject(i);
                String id = locJson.getString("airportId");
                String name = locJson.getString("airportName");
                String city = locJson.getString("airportCity");
                String country = locJson.getString("airportCountry");
                String latitude = String.valueOf(locJson.getDouble("airportLatitude"));
                String longitude = String.valueOf(locJson.getDouble("airportLongitude"));

                Response response = CreateLocationController.createLocation(id, name, city, country, latitude, longitude);
                if (response.getStatus() == Status.CREATED) {
                    count++;
                } else {
                    System.err.println("Error cargando ubicación " + id + ": " + response.getMessage() + " (Status: " + response.getStatus() + ")");
                }
            }
            System.out.println("Se cargaron " + count + " ubicaciones.");
        } catch (Exception e) {
            System.err.println("Error al parsear locations.json: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void loadPlanes() {
        String fileContent = getJsonFileContent("planes.json");
        if (fileContent == null) {
            System.err.println("No se pudo cargar el archivo planes.json.");
            return;
        }
        System.out.println("Cargando aviones...");

        try {
            JSONArray planesArray = new JSONArray(new JSONTokener(fileContent));
            int count = 0;
            for (int i = 0; i < planesArray.length(); i++) {
                JSONObject planeJson = planesArray.getJSONObject(i);
                String id = planeJson.getString("id");
                String brand = planeJson.getString("brand");
                String model = planeJson.getString("model");
                String maxCapacity = String.valueOf(planeJson.getInt("maxCapacity"));
                String airline = planeJson.getString("airline");

                Response response = CreatePlaneController.createPlane(id, brand, model, maxCapacity, airline);
                 if (response.getStatus() == Status.CREATED) {
                    count++;
                } else {
                    System.err.println("Error cargando avión " + id + ": " + response.getMessage() + " (Status: " + response.getStatus() + ")");
                }
            }
            System.out.println("Se cargaron " + count + " aviones.");
        } catch (Exception e) {
            System.err.println("Error al parsear planes.json: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void loadPassengers() {
        String fileContent = getJsonFileContent("passengers.json");
        if (fileContent == null) {
            System.err.println("No se pudo cargar el archivo passengers.json.");
            return;
        }
        System.out.println("Cargando pasajeros...");
        
        try {
            JSONArray passengersArray = new JSONArray(new JSONTokener(fileContent));
            int count = 0;
            for (int i = 0; i < passengersArray.length(); i++) {
                JSONObject passJson = passengersArray.getJSONObject(i);
                String id = String.valueOf(passJson.getLong("id")); 
                String firstname = passJson.getString("firstname");
                String lastname = passJson.getString("lastname");
                
                String birthDateStr = passJson.getString("birthDate");
                LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                String year = String.valueOf(birthDate.getYear());
                String month = String.valueOf(birthDate.getMonthValue());
                String day = String.valueOf(birthDate.getDayOfMonth());

                String countryPhoneCode = String.valueOf(passJson.getInt("countryPhoneCode"));
                String phone = String.valueOf(passJson.getLong("phone"));
                String country = passJson.getString("country");

                Response response = CreatePassengerController.createPassenger(id, firstname, lastname, year, month, day, countryPhoneCode, phone, country);
                if (response.getStatus() == Status.CREATED) {
                    count++;
                } else {
                    System.err.println("Error cargando pasajero " + id + ": " + response.getMessage() + " (Status: " + response.getStatus() + ")");
                }
            }
            System.out.println("Se cargaron " + count + " pasajeros.");
        } catch (Exception e) {
            System.err.println("Error al parsear passengers.json: " + e.getMessage());
             e.printStackTrace();
        }
    }

    private static void loadFlights() {
        String fileContent = getJsonFileContent("flights.json");
        if (fileContent == null) {
            System.err.println("No se pudo cargar el archivo flights.json.");
            return;
        }
        System.out.println("Cargando vuelos...");

        try {
            JSONArray flightsArray = new JSONArray(new JSONTokener(fileContent));
            int count = 0;
            for (int i = 0; i < flightsArray.length(); i++) {
                JSONObject flightJson = flightsArray.getJSONObject(i);
                String id = flightJson.getString("id");
                String planeId = flightJson.getString("plane");
                String departureLocationId = flightJson.getString("departureLocation");
                String arrivalLocationId = flightJson.getString("arrivalLocation");
                
                String scaleLocationId = ""; 
                if (flightJson.has("scaleLocation") && !flightJson.isNull("scaleLocation")) {
                    scaleLocationId = flightJson.getString("scaleLocation");
                }

                String departureDateStr = flightJson.getString("departureDate");
                LocalDateTime departureDateTime = LocalDateTime.parse(departureDateStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String year = String.valueOf(departureDateTime.getYear());
                String month = String.valueOf(departureDateTime.getMonthValue());
                String day = String.valueOf(departureDateTime.getDayOfMonth());
                String hour = String.valueOf(departureDateTime.getHour());
                String minute = String.valueOf(departureDateTime.getMinute());

                String hoursDurationArrival = String.valueOf(flightJson.getInt("hoursDurationArrival"));
                String minutesDurationArrival = String.valueOf(flightJson.getInt("minutesDurationArrival"));
                String hoursDurationScale = String.valueOf(flightJson.getInt("hoursDurationScale"));
                String minutesDurationScale = String.valueOf(flightJson.getInt("minutesDurationScale"));
                
                if (scaleLocationId.trim().isEmpty()) {
                    hoursDurationScale = "0";
                    minutesDurationScale = "0";
                }

                Response response = CreateFlightController.createFlight(id, planeId, departureLocationId, arrivalLocationId, scaleLocationId,
                        year, month, day, hour, minute,
                        hoursDurationArrival, minutesDurationArrival,
                        hoursDurationScale, minutesDurationScale);
                
                if (response.getStatus() == Status.CREATED) {
                    count++;
                } else {
                    System.err.println("Error cargando vuelo " + id + ": " + response.getMessage() + " (Status: " + response.getStatus() + ")");
                }
            }
            System.out.println("Se cargaron " + count + " vuelos.");
        } catch (Exception e) {
            System.err.println("Error al parsear flights.json: " + e.getMessage());
            e.printStackTrace();
        }
    }
}