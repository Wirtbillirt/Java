import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Ejercicio6{

public static void main(String[] args) {
int numMeses = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de meses:"));

double[] toneladasMes = new double[numMeses];

for (int i = 0; i < numMeses; i++) {
toneladasMes[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las toneladas cosechadas para el mes " + (i + 1) + ":"));
}

double promedioAnual = calcularPromedioAnual(toneladasMes);

int mesesSuperiores = contarMesesSuperiores(toneladasMes, promedioAnual);
int mesesInferiores = numMeses - mesesSuperiores;

JTextArea resultadoTextArea = new JTextArea("Promedio anual de toneladas cosechadas: " + promedioAnual + "\n");
resultadoTextArea.append("Meses con cosecha superior al promedio anual: " + mesesSuperiores + "\n");
resultadoTextArea.append("Meses con cosecha inferior al promedio anual: " + mesesInferiores + "\n");

JOptionPane.showMessageDialog(null, resultadoTextArea, "Información de Cosecha de Cereales", JOptionPane.PLAIN_MESSAGE);
}

public static double calcularPromedioAnual(double[] toneladasMes) {
double totalToneladas = 0;
for (double toneladas : toneladasMes) {
totalToneladas += toneladas;
}
return totalToneladas / toneladasMes.length;
}

public static int contarMesesSuperiores(double[] toneladasMes, double promedioAnual) {
int contador = 0;
for (double toneladas : toneladasMes) {
if (toneladas > promedioAnual) {
contador++;
}
}
return contador;
}
}
