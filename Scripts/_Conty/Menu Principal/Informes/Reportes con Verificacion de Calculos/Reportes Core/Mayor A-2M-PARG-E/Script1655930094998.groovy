import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.lang.Float as Float

/**
 * Fecha creacion : 22-06-2022
 * QA : Santiago Marrugo
 */

//Tipo de mayor
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDTipoDeMayor'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
//Importes en dos monedas
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDImportesEn'), '2', false)
WebUI.delay(1)
//Moneda uno en pesos argentinos
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDMonedaUno'), '3', false)
WebUI.delay(1)
//Moneda dos en euros
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDMonedaDos'), '9', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/BotonAceptarPopupMayores'))
WebUI.delay(8)


//Verificamos la generacion del reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Mayor-A-2M-PARG-E'))
println(tituloReporte)
assert tituloReporte == 'Mayor analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte-Mayor A-2M-PARG-E'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. $AR y €'
WebUI.delay(1)

//Se verifica las fechas de los asientos
def String diaLinea1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea1MayorA2MPARGE'))
println(diaLinea1)
def String diaLinea2 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea2MayorA2MPARGE'))
println(diaLinea2)
def String diaLinea3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea3MayorA2MPARGE'))
println(diaLinea3)

assert diaLinea1 == '11/01/2022' && diaLinea2 == '11/01/2022' && diaLinea3 == '11/01/2022'

//Verificamos los valores del reporte en dolares y euros
//Encabezados de las columnas en dolares y euros
def String lblDebe$AR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelDebePARG'))
def String lblHaber$AR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelHaberPARG'))
def String lblSaldo$AR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelSaldoPARG'))


assert lblDebe$AR == 'Debe $AR' && lblHaber$AR == 'Haber $AR' && lblSaldo$AR == 'Saldo $AR'

//Linea 1
println('---Linea 1---')
def String valorL1DebePARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebePARG-MA'))
def String valorL1SaldoPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1SaldoPARG-MA'))
def String valorL1DebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebeEUR-MA-PARG'))
def String valorL1SaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1SaldoEUR-MA-PARG'))


/**
 * Esto tiene un bug ya que los valores de Debe $AR y Saldo $AR no son correctos, los valores correctos para ambos casos es 1,614,577.05 BUG # 248007
 */
assert valorL1DebePARG == '1,614,565.68' && valorL1SaldoPARG == '1,614,565.68' && valorL1DebeEUR == '13,777.88' && valorL1SaldoEUR == '13,777.88'

//linea 2
println('---Linea 2---')
def String valorL2HaberPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberPARG-MA'))
def String valorL2SaldoPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2SaldoPARG-MA'))
def String valorL2HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberEUR-MA-PARG'))
def String valorL2SaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2SaldoEUR-MA-PARG'))

/**
 * Esto tiene un bug ya que los valores de Haber $AR y Saldo $AR no son correctos, los valores correctos para Haber es 290,830.87 y pasa Saldo -290,830.87 BUG # 248007
 */
assert valorL2HaberPARG == '290,828.82' && valorL2SaldoPARG == '-290,828.82' && valorL2HaberEUR == '2,481.78' && valorL2SaldoEUR == '-2,481.78'

//linea 3
println('---Linea 3---')
def String valorL3HaberPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberPARG-MA'))
def String valorL3SaldoPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3SaldoPARG-MA'))
def String valorL3HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberEUR-MA-PARG'))
def String valorL3SaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3SaldoEUR-MA-PARG'))

/**
 * Esto tiene un bug ya que los valores de Haber $AR y Saldo $AR no son correctos, los valores correctos para Haber es 1,323,746.18 y pasa Saldo -1,323,746.18 BUG # 248007
 */
assert valorL3HaberPARG == '1,323,736.86' && valorL3SaldoPARG == '-1,323,736.86' && valorL3HaberEUR == '11,296.09' && valorL3SaldoEUR == '-11,296.09'

//Total debitos
println('---Total debitos---')
def String totalDebPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalDebitosMA-PARG'))
def String totalDebEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalDebitosMA-EUR'))

/**
 * Esto tiene un bug ya que el valor del total debitos en $AR no es correcto, el valor correcto para total debitos en $AR es 1,614,577.05 BUG # 248007
 * el valor total debitos en EUROS no es correcto, el valor correcto es 13,777.87
 */
assert totalDebPARG == '1,614,565.68' && totalDebEUR == '13,777.88'

//Total creditos
println('---Total creditos---')
def String totalCrePARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalCreditosMA-PARG'))
def String totalCreEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalCreditosMA-EUR'))

/**
 * Esto tiene un bug ya que el valor del total creditos en $AR no es correcto, el valor correcto para total creditos en $AR es 1,614,577.05 BUG # 248007
 */
assert totalCrePARG == '1,614,565.68' && totalCreEUR == '13,777.87'

//Total saldo deudores
println('---Total saldo deudores---')
def String totalSalDeudoresPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoDeuMA-PARG'))
def String totalSalDeudoresEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoDeuMA-EUR'))

/**
 * Esto tiene un bug ya que el valor del total saldos deudores en $AR no es correcto, el valor correcto para total saldos deudores en $AR es 1,614,577.05 BUG # 248007
 * el valor total saldos deudores en EUROS no es correcto, el valor correcto es 13,777.87
 */
assert totalSalDeudoresPARG == '1,614,565.68' && totalSalDeudoresEUR == '13,777.88'

//Total saldo acreedores
println('---Total saldo acreedores---')
def String totalSalAcreedoresPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoAcreeMA-PARG'))
def String totalSalAcreedoresEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoAcreeMA-EUR'))

/**
 * Esto tiene un bug ya que el valor del total saldos acreedores en $AR no es correcto, el valor correcto en $AR es 1,614,577.05 BUG # 248007
 */
assert totalSalAcreedoresPARG == '1,614,565.68' && totalSalAcreedoresEUR == '13,777.87'

//Saldo deudores menos acreedores
def String resultadoDeuAcrePARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ResultadoDeuAcreeMA-PARG'))
println(resultadoDeuAcrePARG)
def String resultadoDeuAcreEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ResultadoDeuAcreeMA-EUR'))
println(resultadoDeuAcreEUR)

//Quitamos las comas (,) que tiene la cantidad para poder convertirlo a float y hacer la respectiva resta
totalSalDeudoresPARG = totalSalDeudoresPARG.replace(',', '')
println(totalSalDeudoresPARG)
totalSalAcreedoresPARG = totalSalAcreedoresPARG.replace(',', '')
println(totalSalAcreedoresPARG)

//Pesos Argentinos
println('---- Convertimos los valores de pesos argentinos a float ----')
def float saldoDeudoresPARG = Float.parseFloat(totalSalDeudoresPARG)//1,614,565.68 *** El valor correcto es 1,614,577.05 BUG # 248007
def float saldoAcreedoresPARG = Float.parseFloat(totalSalAcreedoresPARG)//1,614,565.68 *** El valor correcto es 1,614,577.05 BUG # 248007
def float resultadoPARG = Float.parseFloat(resultadoDeuAcrePARG)//0.00

//Hacemos la resta de los valores y se guardan en una variable float y despues se compara con el resultado de los saldos de deudores menos el saldo de acreedores
def float restaPARG = saldoDeudoresPARG - saldoAcreedoresPARG
println(restaPARG)//0.00
println(resultadoPARG)//0.00
assert resultadoPARG == restaPARG

//Quitamos las comas (,) que tiene la cantidad para poder convertirlo a float y hacer la respectiva resta
totalSalDeudoresEUR = totalSalDeudoresEUR.replace(',', '')
println(totalSalDeudoresEUR)
totalSalAcreedoresEUR = totalSalAcreedoresEUR.replace(',', '')
println(totalSalAcreedoresEUR)

//Euros
println('---- Convertimos los valores de euros a float ----')
def float saldoDeudoresEUR = Float.parseFloat(totalSalDeudoresEUR)//13,777.88 *** El valor correcto es 13,777.87 BUG # 248007
def float saldoAcreedoresEUR = Float.parseFloat(totalSalAcreedoresEUR)//13,777.87
def float resultadoEUR = Float.parseFloat(resultadoDeuAcreEUR)//0.01 *** El valor correcto es 0.00 BUG # 248007

//Hacemos la resta de los valores y se guardan en una variable float y despues se compara con el resultado de los saldos de deudores menos el saldo de acreedores
def float restaEUR = saldoDeudoresEUR - saldoAcreedoresEUR
//Redondeamos el valor de la resta
restaEUR = Math.round(restaEUR * 100)/100
println(restaEUR)//0.01 *** El valor correcto es 0.00 BUG # 248007
println(resultadoEUR)//0.01 *** El valor correcto es 0.00 BUG # 248007
assert resultadoEUR == restaEUR

