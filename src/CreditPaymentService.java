// Сайт   https://journal.tinkoff.ru/guide/credit-payment/
// Входные параметры:
// Сумма кредита                                      sum
// Срок кредита - 12 месяцев, 24 месяца, 36 месяцев.  time
// Процентная ставка(год)                             percent
// Процентная ставка(месяц)                           MesPercent
// Ежемесячный платеж                                 MonthlyPayment
// Коэффициент аннуитета                              Сoefficient
// (MesPercent + 1)                                   MP

//    Стандартная формула расчета аннуитетного платежа выглядит так:
//    Сумма кредита * Коэффициент аннуитета

public class CreditPaymentService {
    public int calculate(int sum, int time, float percent) {
        int MonthlyPayment;
        float Coefficient;
        float MesPercent;
        float MP;

        // 1 Этап рассчета:
        MesPercent = ((percent / 100) / time);  // рассчитываем месячную процентную ставку

        MP = (MesPercent + 1);                  // для удобства вывела это в отдельную переменную.

        // 2 Этап рассчета:
        Coefficient = (float) ((MesPercent * Math.pow(MP, time)) / (Math.pow(MP, time) - 1));

        // 3 Этап рассчета:
        MonthlyPayment = (int) (sum * Coefficient);
        return MonthlyPayment;

    }
}