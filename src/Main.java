import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("""
                ------------- Colisão de Trens -------------

                Dois trens estão prestes a colidir, precisamos
                de suas velocidades e posições iniciais
                para definir o tempo e ponto de colisão""");

        label:
        while(true) {
            double pos1;
            try {
                System.out.println("Digite a Posição inicial do trem 1 (entre 0Km e 10.000Km): ");
                pos1 = ler.nextDouble();
                if (pos1 < 0.0 || pos1 > 10000.0) {
                    throw new Exception("Valor inválido!");
                }
            } catch (Exception var19) {
                var19.printStackTrace();
                ler.nextLine();
                continue;
            }

            while(true) {
                double pos2;
                try {
                    System.out.println("Digite a Posição inicial do trem 2 (entre 0Km e 10.000Km): ");
                    pos2 = ler.nextDouble();
                    if (pos2 < 0.0 || pos2 > 10000.0) {
                        throw new Exception("Valor inválido");
                    }
                } catch (Exception var18) {
                    var18.printStackTrace();
                    ler.nextLine();
                    continue;
                }

                while(true) {
                    double vel1;
                    try {
                        System.out.println("Digite a Velocidade do trem 1 (limite de 300Km/h): ");
                        vel1 = ler.nextDouble();
                        if (vel1 < 0.0 || vel1 > 300.0) {
                            throw new Exception("Valor inválido");
                        }
                    } catch (Exception var17) {
                        var17.printStackTrace();
                        ler.nextLine();
                        continue;
                    }

                    while(true) {
                        double vel2;
                        try {
                            System.out.println("Digite a Velocidade do trem 2 (limite de 300Km/h): ");
                            vel2 = ler.nextDouble();
                            if (vel2 < 0.0 || vel2 > 300.0) {
                                throw new Exception("Valor inválido");
                            }
                        } catch (Exception var16) {
                            var16.printStackTrace();
                            continue;
                        }

                        if (vel1 == 0.0 && vel2 == 0.0) {
                            System.out.println("As velocidades são iguais a 0, logo os trens não irão se mexer e nem colidir.");
                        }

                        if (pos1 > pos2) {
                            System.out.println("O segundo trem iniciou seu trajeto para tras do primeiro, logo eles irão se afastar");
                        } else {
                            double tempo = Math.abs(pos1 - pos2) / (vel1 - (-vel2));
                            double posFinal = pos1 + vel1 * tempo;
                            System.out.printf("Tempo da Colisão: %.1f Horas\nPosição da Colisão: %.1f Km\n", tempo, posFinal);

                            int hora = 17, minuto = 0, segundo = 0;
                            int tempo_segundos = (int)Math.round(tempo*3600.0);
                            while(tempo_segundos > 0) {
                                if (tempo_segundos >= 3600) {
                                    hora = hora + 1;
                                    tempo_segundos = tempo_segundos - 3600;
                                }
                                else if (tempo_segundos >= 60) {
                                    minuto = minuto + 1;
                                    tempo_segundos = tempo_segundos - 60;
                                }
                                else {
                                    segundo = segundo + tempo_segundos;
                                }

                                if (segundo >= 60) {
                                    segundo = segundo - 60;
                                    minuto ++;
                                }
                                if (minuto == 60) {
                                    minuto = 0;
                                    hora++;
                                }
                                if (hora == 24) {
                                    hora = 0;
                                }
                            }
                            System.out.printf("Horário: %d:%d:%d\n\n", hora, minuto, segundo);
                        }

                        ler.nextLine();
                    while (true) {
                        try {
                            System.out.println("Deseja Continuar? [S/N]: ");
                            String decisao = ler.nextLine().toUpperCase();
                            if (Objects.equals(decisao, "S")) {
                                if (Objects.equals(decisao, "N")) {
                                    return;
                                }
                                continue label;
                            }
                            throw new Exception("Digite apenas S ou N ");
                        } catch (Exception var15) {
                            var15.printStackTrace();
                        }
                        }
                    }
                }
            }
        }
    }
}
