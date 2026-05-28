import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    static class Especie {
        String nombreComun;
        String nombreCientifico;
        String grupo;
        String categoria;
        String habitat;
        String ambienteIdeal;
        String humedadIdeal;
        String iluminacionIdeal;
        String advertencia;
        String riesgos;
        String dietaBase;
        double tempMin;
        double tempMax;

        public Especie(String nombreComun, String nombreCientifico, String grupo, String categoria,
                       String habitat, String ambienteIdeal, String humedadIdeal, String iluminacionIdeal,
                       String advertencia, String riesgos, String dietaBase,
                       double tempMin, double tempMax) {
            this.nombreComun = nombreComun;
            this.nombreCientifico = nombreCientifico;
            this.grupo = grupo;
            this.categoria = categoria;
            this.habitat = habitat;
            this.ambienteIdeal = ambienteIdeal;
            this.humedadIdeal = humedadIdeal;
            this.iluminacionIdeal = iluminacionIdeal;
            this.advertencia = advertencia;
            this.riesgos = riesgos;
            this.dietaBase = dietaBase;
            this.tempMin = tempMin;
            this.tempMax = tempMax;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BioHabitatVetUI().mostrarVentana());
    }

    static class BioHabitatVetUI {

        private final Color FONDO = new Color(240, 248, 244);
        private final Color PANEL = Color.WHITE;
        private final Color VERDE = new Color(46, 125, 50);
        private final Color VERDE_SUAVE = new Color(200, 230, 201);
        private final Color TURQUESA_SUAVE = new Color(178, 223, 219);
        private final Color GRIS = new Color(245, 245, 245);
        private final Color TEXTO = new Color(30, 30, 30);

        private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        private final DateTimeFormatter formatoArchivo = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        private final String[] ambientes = {
                "Bosque templado",
                "Estepa o pradera",
                "Cordillera rocosa",
                "Humedal o laguna",
                "Ribera de río",
                "Costa marina",
                "Matorral o zona semiárida",
                "Recinto de rehabilitación húmedo",
                "Recinto de rehabilitación seco",
                "Recinto de cuarentena o aislamiento",
                "Hogar o ambiente doméstico",
                "Corral o ambiente de campo"
        };

        private final String[] humedades = {"Baja", "Media", "Alta"};
        private final String[] iluminaciones = {"Baja", "Media", "Alta"};

        private final Especie[] especies = {

                new Especie("Perro", "Canis lupus familiaris", "Mamífero", "Doméstico",
                        "Ambiente doméstico", "Hogar o ambiente doméstico", "Media", "Media",
                        "Requiere ambiente seguro, hidratación y supervisión clínica si está en rescate.",
                        "Estrés, deshidratación, enfermedades infecciosas.",
                        "Balanceado o dieta indicada por veterinario.",
                        15, 26),

                new Especie("Gato", "Felis catus", "Mamífero", "Doméstico",
                        "Ambiente doméstico", "Hogar o ambiente doméstico", "Media", "Baja a media",
                        "Muy sensible al estrés, ruido y cambios bruscos de ambiente.",
                        "Estrés, anorexia, deshidratación.",
                        "Balanceado o dieta veterinaria específica.",
                        18, 27),

                new Especie("Conejo", "Oryctolagus cuniculus", "Mamífero", "Doméstico/Exótico",
                        "Praderas y madrigueras", "Recinto de rehabilitación seco", "Media", "Media",
                        "Muy sensible al estrés térmico y digestivo.",
                        "Íleo, estrés, hipertermia.",
                        "Heno, vegetales frescos y agua limpia.",
                        15, 24),

                new Especie("Chinchilla", "Chinchilla lanigera", "Mamífero", "Exótico",
                        "Zonas áridas y frías", "Recinto de rehabilitación seco", "Baja", "Media",
                        "Las chinchillas no deben mojarse, ya que la humedad retenida en su pelaje puede generar problemas cutáneos y estrés térmico.",
                        "Golpe de calor, maloclusión, problemas dérmicos.",
                        "Heno, pellets específicos y agua.",
                        10, 20),

                new Especie("Gecko", "Gekkonidae sp.", "Reptil", "Exótico",
                        "Hábitats cálidos", "Recinto de rehabilitación seco", "Media", "Media",
                        "Necesita gradiente térmico y control de humedad según la especie.",
                        "Muda incompleta, enfermedad metabólica ósea.",
                        "Insectívoro.",
                        24, 30),

                new Especie("Iguana", "Iguana iguana", "Reptil", "Exótico",
                        "Ambientes tropicales", "Recinto de rehabilitación húmedo", "Alta", "Alta",
                        "Requiere iluminación UVB y control térmico estricto.",
                        "Enfermedad metabólica ósea, deshidratación.",
                        "Herbívoro.",
                        26, 32),

                new Especie("Tortuga terrestre", "Testudinidae", "Reptil", "Exótico",
                        "Zonas secas y templadas", "Recinto de rehabilitación seco", "Baja a media", "Alta",
                        "Ambiente seco, con acceso a luz y temperatura controlada.",
                        "Problemas respiratorios, alteraciones del caparazón.",
                        "Herbívoro.",
                        22, 30),

                new Especie("Gallina", "Gallus gallus domesticus", "Ave", "Doméstico/campo",
                        "Corrales y campo", "Corral o ambiente de campo", "Media", "Alta",
                        "Sensibles a hacinamiento y falta de ventilación.",
                        "Problemas respiratorios, estrés térmico.",
                        "Omnívora/granos.",
                        18, 28),

                new Especie("Caballo", "Equus ferus caballus", "Mamífero", "Campo",
                        "Praderas y corrales", "Corral o ambiente de campo", "Media", "Alta",
                        "Necesita espacio, ventilación y control de hidratación.",
                        "Cólicos, estrés, lesiones musculares.",
                        "Herbívoro/pasto y heno.",
                        10, 25),

                new Especie("Cabra", "Capra aegagrus hircus", "Mamífero", "Campo",
                        "Zonas secas y corrales", "Corral o ambiente de campo", "Baja a media", "Alta",
                        "Tolera clima variable, pero requiere buena ventilación.",
                        "Parásitos, estrés, deshidratación.",
                        "Herbívoro.",
                        10, 28),

                new Especie("Oveja", "Ovis aries", "Mamífero", "Campo",
                        "Praderas y corrales", "Corral o ambiente de campo", "Media", "Media",
                        "Sensibles a humedad excesiva en pezuñas y hacinamiento.",
                        "Parásitos, estrés, problemas podales.",
                        "Herbívoro.",
                        8, 24),

                new Especie("Guanaco", "Lama guanicoe", "Mamífero", "Camélido",
                        "Estepas y cordillera", "Estepa o pradera", "Baja a media", "Alta",
                        "Sensibles al estrés por captura y manipulación prolongada.",
                        "Deshidratación, estrés, lesiones.",
                        "Herbívoro.",
                        5, 20),

                new Especie("Coipo", "Myocastor coypus", "Mamífero", "Semiacuático",
                        "Humedales y ríos", "Ribera de río", "Alta", "Media",
                        "Necesita contacto con ambiente húmedo o acuático.",
                        "Infecciones cutáneas, estrés.",
                        "Herbívoro.",
                        10, 22),

                new Especie("Pudú", "Pudu puda", "Mamífero", "Cérvido",
                        "Bosques del sur", "Bosque templado", "Media a alta", "Baja a media",
                        "Especie altamente sensible al estrés humano.",
                        "Parásitos, lesiones por escape, estrés severo.",
                        "Herbívoro.",
                        8, 18),

                new Especie("Huemul", "Hippocamelus bisulcus", "Mamífero", "Cérvido",
                        "Bosques andinos", "Bosque templado", "Media", "Media",
                        "Especie en peligro, muy sensible a perturbación humana.",
                        "Estrés, debilitamiento, lesiones.",
                        "Herbívoro.",
                        5, 15),

                new Especie("Puma", "Puma concolor", "Mamífero", "Carnívoro silvestre",
                        "Zonas montañosas y abiertas", "Cordillera rocosa", "Baja a media", "Media",
                        "Carnívoro de alta reactividad; requiere mínimo contacto humano.",
                        "Estrés severo, deshidratación, lesiones por agitación.",
                        "Carnívoro.",
                        5, 22),

                new Especie("Zorro Culpeo", "Lycalopex culpaeus", "Mamífero", "Cánido",
                        "Matorral y zonas abiertas", "Matorral o zona semiárida", "Baja a media", "Media",
                        "Alta reactividad al cautiverio y al contacto humano.",
                        "Estrés, deshidratación, agitación.",
                        "Carnívoro.",
                        5, 22),

                new Especie("Zorro Chilla", "Lycalopex griseus", "Mamífero", "Cánido",
                        "Zonas abiertas y semiáridas", "Matorral o zona semiárida", "Baja a media", "Media",
                        "Especie nerviosa, con alto estrés en confinamiento.",
                        "Estrés, deshidratación, lesiones.",
                        "Carnívoro/omnívoro.",
                        6, 24),

                new Especie("Vizcacha", "Lagidium viscacia", "Mamífero", "Roedor silvestre",
                        "Zonas rocosas andinas", "Cordillera rocosa", "Baja", "Media",
                        "Muy sensible a manipulación y cambios bruscos de ambiente.",
                        "Estrés, lesiones por escape.",
                        "Herbívoro.",
                        5, 18),

                new Especie("Lobo Marino común", "Otaria flavescens", "Mamífero", "Mamífero marino",
                        "Costa y litoral", "Costa marina", "Alta", "Media a alta",
                        "Requiere acceso a ambiente costero y evaluación especializada.",
                        "Estrés, deshidratación, infecciones.",
                        "Carnívoro/piscívoro.",
                        8, 22),

                new Especie("Monito del Monte", "Dromiciops gliroides", "Mamífero", "Marsupial",
                        "Bosque templado húmedo", "Bosque templado", "Alta", "Baja a media",
                        "Muy sensible a cambios bruscos de temperatura y manipulación.",
                        "Hipotermia, estrés, debilitamiento.",
                        "Omnívoro/insectívoro-frugívoro.",
                        8, 18),

                new Especie("Cóndor Andino", "Vultur gryphus", "Ave", "Rapaz",
                        "Cordillera", "Cordillera rocosa", "Baja a media", "Alta",
                        "Requiere amplio espacio y baja intervención.",
                        "Lesiones alares, estrés, debilidad.",
                        "Carroñero.",
                        0, 18),

                new Especie("Tucúquere", "Bubo magellanicus", "Ave", "Rapaz nocturna",
                        "Zonas abiertas, bosque y matorral", "Matorral o zona semiárida", "Media", "Baja",
                        "Requiere baja perturbación y manejo cuidadoso del estrés.",
                        "Lesiones, estrés, problemas visuales.",
                        "Carnívoro.",
                        8, 22),

                new Especie("Flamenco Chileno", "Phoenicopterus chilensis", "Ave", "Humedal",
                        "Lagunas y humedales", "Humedal o laguna", "Media a alta", "Alta",
                        "Muy sensible a alteraciones del agua y hacinamiento.",
                        "Deshidratación, alteraciones locomotoras.",
                        "Filtrador/omnívoro especializado.",
                        12, 28)
        };

        public void mostrarVentana() {
            JFrame frame = new JFrame("BioHabitat Vet Intelligence");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1450, 820);
            frame.setLocationRelativeTo(null);

            JPanel root = new JPanel(new BorderLayout(12, 12));
            root.setBackground(FONDO);
            root.setBorder(new EmptyBorder(15, 15, 15, 15));

            JLabel titulo = new JLabel("BioHabitat Vet Intelligence", SwingConstants.CENTER);
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
            titulo.setForeground(VERDE);

            JLabel subtitulo = new JLabel("Motor inteligente de conocimiento veterinario y ambiental", SwingConstants.CENTER);
            subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            subtitulo.setForeground(TEXTO);

            JPanel top = new JPanel(new GridLayout(2, 1));
            top.setBackground(FONDO);
            top.add(titulo);
            top.add(subtitulo);
            root.add(top, BorderLayout.NORTH);

            // ===== IZQUIERDA =====
            JPanel izquierda = new JPanel(new GridBagLayout());
            izquierda.setBackground(PANEL);
            izquierda.setBorder(new EmptyBorder(20, 20, 20, 20));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(7, 7, 7, 7);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;

            JTextField txtPaciente = new JTextField();

            JComboBox<String> comboEspecie = new JComboBox<>();
            for (Especie e : especies) {
                comboEspecie.addItem(e.nombreComun);
            }

            JTextField txtBusquedaCientifica = new JTextField();
            JButton btnBuscarCientifico = new JButton("Buscar por nombre científico");
            estilizarBoton(btnBuscarCientifico, TURQUESA_SUAVE, TEXTO);

            JTextField txtTemp = new JTextField();
            JComboBox<String> comboHumedad = new JComboBox<>(humedades);
            JComboBox<String> comboIluminacion = new JComboBox<>(iluminaciones);
            JComboBox<String> comboAmbiente = new JComboBox<>(ambientes);
            JTextField txtDieta = new JTextField();
            JTextField txtComportamiento = new JTextField();
            JTextArea txtObservaciones = new JTextArea(4, 20);
            JTextField txtMedicamentoActual = new JTextField();
            JTextField txtMedicamentoAnterior = new JTextField();
            JTextField txtMedicamentoProximo = new JTextField();
            JTextField txtFechaProxima = new JTextField();

            txtObservaciones.setLineWrap(true);
            txtObservaciones.setWrapStyleWord(true);

            agregarCampo(izquierda, gbc, "Nombre del paciente:", txtPaciente);
            agregarCampo(izquierda, gbc, "Especie:", comboEspecie);
            agregarCampo(izquierda, gbc, "Buscar nombre científico:", txtBusquedaCientifica);

            gbc.gridx = 0;
            gbc.gridwidth = 2;
            izquierda.add(btnBuscarCientifico, gbc);
            gbc.gridy++;
            gbc.gridwidth = 1;

            agregarCampo(izquierda, gbc, "Temperatura actual (°C):", txtTemp);
            agregarCampo(izquierda, gbc, "Humedad actual:", comboHumedad);
            agregarCampo(izquierda, gbc, "Iluminación actual:", comboIluminacion);
            agregarCampo(izquierda, gbc, "Ambiente actual:", comboAmbiente);
            agregarCampo(izquierda, gbc, "Dieta alimentaria:", txtDieta);
            agregarCampo(izquierda, gbc, "Comportamiento:", txtComportamiento);

            gbc.gridx = 0;
            gbc.gridwidth = 2;
            izquierda.add(new JLabel("Observaciones:"), gbc);
            gbc.gridy++;
            izquierda.add(new JScrollPane(txtObservaciones), gbc);
            gbc.gridy++;
            gbc.gridwidth = 1;

            agregarCampo(izquierda, gbc, "Medicamento actual:", txtMedicamentoActual);
            agregarCampo(izquierda, gbc, "Medicamento anterior:", txtMedicamentoAnterior);
            agregarCampo(izquierda, gbc, "Próximo medicamento:", txtMedicamentoProximo);
            agregarCampo(izquierda, gbc, "Fecha próximo medicamento:", txtFechaProxima);

            JButton btnEvaluar = new JButton("Evaluar");
            JButton btnLimpiar = new JButton("Limpiar");
            JButton btnHTML = new JButton("Abrir HTML");

            estilizarBoton(btnEvaluar, VERDE, Color.WHITE);
            estilizarBoton(btnLimpiar, VERDE_SUAVE, TEXTO);
            estilizarBoton(btnHTML, TURQUESA_SUAVE, TEXTO);

            gbc.gridx = 0;
            gbc.gridwidth = 2;
            izquierda.add(btnEvaluar, gbc);
            gbc.gridy++;
            izquierda.add(btnLimpiar, gbc);
            gbc.gridy++;
            izquierda.add(btnHTML, gbc);

            // ===== CENTRO =====
            JTextArea areaResultado = new JTextArea();
            areaResultado.setEditable(false);
            areaResultado.setFont(new Font("Consolas", Font.PLAIN, 15));
            areaResultado.setLineWrap(true);
            areaResultado.setWrapStyleWord(true);
            areaResultado.setBackground(new Color(250, 255, 250));
            areaResultado.setForeground(TEXTO);

            JScrollPane scrollResultado = new JScrollPane(areaResultado);
            scrollResultado.setBorder(BorderFactory.createTitledBorder("Evaluación clínica y ambiental"));

            // ===== DERECHA =====
            JTextArea areaHistorial = new JTextArea();
            areaHistorial.setEditable(false);
            areaHistorial.setFont(new Font("Consolas", Font.PLAIN, 13));
            areaHistorial.setBackground(GRIS);
            areaHistorial.setForeground(TEXTO);
            areaHistorial.setLineWrap(true);
            areaHistorial.setWrapStyleWord(true);

            JScrollPane scrollHistorial = new JScrollPane(areaHistorial);
            scrollHistorial.setBorder(BorderFactory.createTitledBorder("Historial del paciente actual"));

            root.add(izquierda, BorderLayout.WEST);
            root.add(scrollResultado, BorderLayout.CENTER);
            root.add(scrollHistorial, BorderLayout.EAST);

            final String[] ultimoReporte = {""};

            btnBuscarCientifico.addActionListener(e -> {
                String busqueda = txtBusquedaCientifica.getText().trim().toLowerCase();

                if (busqueda.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Escribe parte del nombre científico.",
                            "Búsqueda vacía",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int indiceEncontrado = buscarEspeciePorNombreCientifico(busqueda);

                if (indiceEncontrado < 0) {
                    indiceEncontrado = buscarEspecieParecida(busqueda);
                }

                if (indiceEncontrado >= 0) {
                    comboEspecie.setSelectedIndex(indiceEncontrado);
                    JOptionPane.showMessageDialog(frame,
                            "Especie encontrada: " + especies[indiceEncontrado].nombreComun +
                                    " (" + especies[indiceEncontrado].nombreCientifico + ")",
                            "Búsqueda exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "No se encontró una especie con ese nombre científico.",
                            "Sin resultados",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            txtBusquedaCientifica.addActionListener(e -> btnBuscarCientifico.doClick());

            btnEvaluar.addActionListener(e -> {
                try {
                    String paciente = txtPaciente.getText().trim();
                    if (paciente.isEmpty()) paciente = "Sin nombre";

                    Especie especie = especies[comboEspecie.getSelectedIndex()];
                    double tempActual = Double.parseDouble(txtTemp.getText().trim());

                    String humedadActual = comboHumedad.getSelectedItem().toString();
                    String iluminacionActual = comboIluminacion.getSelectedItem().toString();
                    String ambienteActual = comboAmbiente.getSelectedItem().toString();
                    String dieta = txtDieta.getText().trim();
                    String comportamiento = txtComportamiento.getText().trim();
                    String observaciones = txtObservaciones.getText().trim();
                    String medActual = txtMedicamentoActual.getText().trim();
                    String medAnterior = txtMedicamentoAnterior.getText().trim();
                    String medProximo = txtMedicamentoProximo.getText().trim();
                    String fechaProxima = txtFechaProxima.getText().trim();

                    boolean tempCompatible = tempActual >= especie.tempMin && tempActual <= especie.tempMax;
                    boolean humedadCompatible = humedadActual.toLowerCase().contains(normalizar(especie.humedadIdeal).split(" ")[0]);
                    boolean iluminacionCompatible = iluminacionActual.toLowerCase().contains(normalizar(especie.iluminacionIdeal).split(" ")[0]);
                    boolean ambienteCompatible = ambienteActual.equalsIgnoreCase(especie.ambienteIdeal);

                    String riesgo = "BAJO";

                    if (!tempCompatible || !ambienteCompatible) {
                        riesgo = "ALTO";
                    } else if (!humedadCompatible || !iluminacionCompatible) {
                        riesgo = "MODERADO";
                    }

                    String fechaHora = LocalDateTime.now().format(formatoFecha);

                    StringBuilder resultado = new StringBuilder();
                    resultado.append("============================================\n");
                    resultado.append("BIOHABITAT VET INTELLIGENCE\n");
                    resultado.append("============================================\n");
                    resultado.append("Fecha y hora: ").append(fechaHora).append("\n\n");

                    resultado.append("Paciente: ").append(paciente).append("\n");
                    resultado.append("Especie: ").append(especie.nombreComun).append(" (").append(especie.nombreCientifico).append(")\n");
                    resultado.append("Grupo: ").append(especie.grupo).append("\n");
                    resultado.append("Categoría funcional: ").append(especie.categoria).append("\n");
                    resultado.append("Hábitat natural: ").append(especie.habitat).append("\n\n");

                    resultado.append("--- Parámetros ideales ---\n");
                    resultado.append("Temperatura ideal: ").append(especie.tempMin).append("°C a ").append(especie.tempMax).append("°C\n");
                    resultado.append("Humedad ideal: ").append(especie.humedadIdeal).append("\n");
                    resultado.append("Iluminación ideal: ").append(especie.iluminacionIdeal).append("\n");
                    resultado.append("Ambiente ideal: ").append(especie.ambienteIdeal).append("\n\n");

                    resultado.append("--- Advertencia médica crítica ---\n");
                    resultado.append(especie.advertencia).append("\n\n");

                    resultado.append("--- Riesgos frecuentes ---\n");
                    resultado.append(especie.riesgos).append("\n\n");

                    resultado.append("--- Dieta y seguimiento ---\n");
                    resultado.append("Dieta base recomendada: ").append(especie.dietaBase).append("\n");
                    resultado.append("Dieta ingresada: ").append(dieta).append("\n");
                    resultado.append("Comportamiento observado: ").append(comportamiento).append("\n");
                    resultado.append("Observaciones: ").append(observaciones).append("\n\n");

                    resultado.append("--- Medicación ---\n");
                    resultado.append("Medicamento actual: ").append(medActual).append("\n");
                    resultado.append("Medicamento anterior: ").append(medAnterior).append("\n");
                    resultado.append("Próximo medicamento: ").append(medProximo).append("\n");
                    resultado.append("Fecha próxima: ").append(fechaProxima).append("\n\n");

                    resultado.append("--- Evaluación ambiental actual ---\n");
                    resultado.append("Temperatura actual: ").append(tempActual).append("°C -> ").append(tempCompatible ? "Compatible" : "No compatible").append("\n");
                    resultado.append("Humedad actual: ").append(humedadActual).append(" -> ").append(humedadCompatible ? "Compatible" : "No compatible").append("\n");
                    resultado.append("Iluminación actual: ").append(iluminacionActual).append(" -> ").append(iluminacionCompatible ? "Compatible" : "No compatible").append("\n");
                    resultado.append("Ambiente actual: ").append(ambienteActual).append(" -> ").append(ambienteCompatible ? "Compatible" : "No compatible").append("\n\n");

                    resultado.append("--- Resultado general ---\n");
                    resultado.append("Nivel de riesgo: ").append(riesgo).append("\n");

                    if (riesgo.equals("ALTO")) {
                        resultado.append("Conclusión: el entorno actual no es adecuado para la recuperación de esta especie.\n");
                    } else if (riesgo.equals("MODERADO")) {
                        resultado.append("Conclusión: la situación requiere supervisión y ajustes ambientales.\n");
                    } else {
                        resultado.append("Conclusión: las condiciones son adecuadas para el paciente.\n");
                    }

                    areaResultado.setText(resultado.toString());

                    areaHistorial.append("\n[" + fechaHora + "] " + paciente + " - " + especie.nombreComun + " - Riesgo: " + riesgo + "\n");
                    areaHistorial.append("Observación breve: " + observaciones + "\n");
                    areaHistorial.append("--------------------------------------------------\n");

                    guardarTXTGeneral(resultado.toString());
                    guardarHistorialEspecieFecha(especie.nombreComun, resultado.toString());

                    ultimoReporte[0] = resultado.toString();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Revisa que la temperatura esté bien escrita.",
                            "Error de ingreso",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            btnHTML.addActionListener(e -> {
                if (!ultimoReporte[0].isEmpty()) {
                    generarHTML(ultimoReporte[0]);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Primero debes generar una evaluación.",
                            "Sin datos",
                            JOptionPane.WARNING_MESSAGE);
                }
            });

            btnLimpiar.addActionListener(e -> {
                txtPaciente.setText("");
                txtBusquedaCientifica.setText("");
                txtTemp.setText("");
                txtDieta.setText("");
                txtComportamiento.setText("");
                txtObservaciones.setText("");
                txtMedicamentoActual.setText("");
                txtMedicamentoAnterior.setText("");
                txtMedicamentoProximo.setText("");
                txtFechaProxima.setText("");
                areaResultado.setText("");
            });

            frame.setContentPane(root);
            frame.setVisible(true);
        }

        private void agregarCampo(JPanel panel, GridBagConstraints gbc, String etiqueta, JComponent campo) {
            gbc.gridx = 0;
            panel.add(new JLabel(etiqueta), gbc);
            gbc.gridx = 1;
            gbc.weightx = 1;
            panel.add(campo, gbc);
            gbc.gridy++;
            gbc.weightx = 0;
        }

        private void estilizarBoton(JButton boton, Color fondo, Color texto) {
            boton.setBackground(fondo);
            boton.setForeground(texto);
            boton.setFocusPainted(false);
            boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        }

        private int buscarEspeciePorNombreCientifico(String texto) {
            String t = normalizar(texto);
            for (int i = 0; i < especies.length; i++) {
                if (normalizar(especies[i].nombreCientifico).contains(t)) {
                    return i;
                }
            }
            return -1;
        }

        private int buscarEspecieParecida(String texto) {
            texto = normalizar(texto);

            int mejorIndice = -1;
            int mejorPuntaje = Integer.MAX_VALUE;

            for (int i = 0; i < especies.length; i++) {
                String nombre = normalizar(especies[i].nombreCientifico);

                int distancia = calcularDistanciaLevenshtein(texto, nombre);

                if (distancia < mejorPuntaje) {
                    mejorPuntaje = distancia;
                    mejorIndice = i;
                }
            }

            if (mejorPuntaje <= 5) {
                return mejorIndice;
            }

            return -1;
        }

        private int calcularDistanciaLevenshtein(String a, String b) {
            int[][] dp = new int[a.length() + 1][b.length() + 1];

            for (int i = 0; i <= a.length(); i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j <= b.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    int costo = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;

                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + costo
                    );
                }
            }

            return dp[a.length()][b.length()];
        }

        private String normalizar(String texto) {
            texto = texto.toLowerCase().trim();
            texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
            return texto.replaceAll("\\p{M}", "");
        }

        private void guardarTXTGeneral(String contenido) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("historial_paciente.txt", true))) {
                bw.write(contenido);
                bw.write("\n============================================================\n\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "No se pudo guardar el historial general en TXT.",
                        "Error de archivo",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        private void guardarHistorialEspecieFecha(String especie, String contenido) {
            String fechaArchivo = LocalDateTime.now().format(formatoArchivo);
            String nombreArchivo = limpiarNombreArchivo(especie) + "_" + fechaArchivo + ".txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
                bw.write(contenido);
                bw.write("\n============================================================\n\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "No se pudo guardar el historial por especie y fecha.",
                        "Error de archivo",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        private String limpiarNombreArchivo(String texto) {
            String limpio = normalizar(texto);
            return limpio.replaceAll("[^a-z0-9_\\-]", "_");
        }

        private void generarHTML(String texto) {
            try {
                String textoHtml = texto
                        .replace("&", "&amp;")
                        .replace("<", "&lt;")
                        .replace(">", "&gt;")
                        .replace("\n", "<br>");

                String html = """
                        <!DOCTYPE html>
                        <html lang="es">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>BioHabitat Vet Intelligence</title>
                            <style>
                                body {
                                    font-family: Segoe UI, Arial, sans-serif;
                                    background: linear-gradient(135deg, #eef8f2, #f8fffa);
                                    margin: 0;
                                    padding: 30px;
                                    color: #222;
                                }
                                .contenedor {
                                    max-width: 1100px;
                                    margin: auto;
                                    background: white;
                                    border-radius: 18px;
                                    box-shadow: 0 8px 24px rgba(0,0,0,0.12);
                                    overflow: hidden;
                                }
                                .encabezado {
                                    background: #2e7d32;
                                    color: white;
                                    padding: 25px 35px;
                                }
                                .encabezado h1 {
                                    margin: 0;
                                    font-size: 38px;
                                }
                                .encabezado p {
                                    margin: 8px 0 0 0;
                                    font-size: 16px;
                                }
                                .contenido {
                                    padding: 35px;
                                    line-height: 1.7;
                                    font-size: 17px;
                                }
                                .bloque {
                                    background: #f6fff7;
                                    border-left: 6px solid #43a047;
                                    padding: 20px;
                                    border-radius: 10px;
                                    white-space: pre-wrap;
                                }
                            </style>
                        </head>
                        <body>
                            <div class="contenedor">
                                <div class="encabezado">
                                    <h1>BioHabitat Vet Intelligence</h1>
                                    <p>Reporte veterinario y ambiental</p>
                                </div>
                                <div class="contenido">
                                    <div class="bloque">%s</div>
                                </div>
                            </div>
                        </body>
                        </html>
                        """.formatted(textoHtml);

                FileWriter fw = new FileWriter("reporte.html");
                fw.write(html);
                fw.close();

                Desktop.getDesktop().browse(new File("reporte.html").toURI());

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "No se pudo generar el HTML.",
                        "Error HTML",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
