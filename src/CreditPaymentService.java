// Сайт   https://journal.tinkoff.ru/guide/credit-payment/
// Входные параметры:
// Сумма кредита                                      sum
// Срок кредита - 12 месяцев, 24 месяца, 36 месяцев.  time
// Процентная ставка(год)                             percent
// Процентная ставка(месяц)                           mesPercent
// Ежемесячный платеж                                 monthlyPayment
// Коэффициент аннуитета                              coefficient
// (MesPercent + 1)                                   mp

//    Стандартная формула расчета аннуитетного платежа выглядит так:
//    Сумма кредита * Коэффициент аннуитета

public class CreditPaymentService {
    public int calculate(int sum, int time, float percent) {
        int monthlyPayment;
        float coefficient;
        float mesPercent;
        float mp;

        // 1 Этап рассчета:
        mesPercent = percent / 100 / 12;  // рассчитываем месячную процентную ставку

        mp = (mesPercent + 1);                  // для удобства вывела это в отдельную переменную.

        // 2 Этап рассчета:
        coefficient = (float) ((mesPercent * Math.pow(mp, time)) / (Math.pow(mp, time) - 1));

        // 3 Этап рассчета:
        monthlyPayment = (int) (sum * coefficient);
        return monthlyPayment;

    }
}