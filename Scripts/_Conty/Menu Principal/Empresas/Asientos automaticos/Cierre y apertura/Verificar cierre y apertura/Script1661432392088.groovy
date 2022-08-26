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
import com.kms.katalon.core.util.KeywordUtil as KWU

/**
 * Fecha creacion : 25-08-2022
 * QA : Santiago Marrugo
 */

//Verificamos los valores de la columna Dia
WebUI.executeJavaScript('hot.selectCell(18, 5)', null)
def String valorDia1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 5)', null)
def String valorDia2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 5)', null)
def String valorDia3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 5)', null)
def String valorDia4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 5)', null)
def String valorDia5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 5)', null)
def String valorDia6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 5)', null)
def String valorDia7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 5)', null)
def String valorDia8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (valorDia1 == '28' && valorDia2 == '28' && valorDia3 == '28' && valorDia4 == '28' 
	 && valorDia5 == '28' && valorDia6 == '28' && valorDia7 == '28' && valorDia8 == '28')

//Verificamos los valores de la columna Debe
WebUI.executeJavaScript('hot.selectCell(18, 6)', null)
def String valorDebe1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 6)', null)
def String valorDebe2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 6)', null)
def String valorDebe3 = WebUI.executeJavaScript('return hot.getValue()', null)

assert valorDebe1 == '3511' && valorDebe2 == '21111' && valorDebe3 == '21333'

//Verificamos los valores de la columna Haber
WebUI.executeJavaScript('hot.selectCell(21, 7)', null)
def String valorHaber1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 7)', null)
def String valorHaber2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 7)', null)
def String valorHaber3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 7)', null)
def String valorHaber4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 7)', null)
def String valorHaber5 = WebUI.executeJavaScript('return hot.getValue()', null)

assert valorHaber1 == '1112011' && valorHaber2 == '11112' &&  valorHaber3 == '1112012' && valorHaber4 == '11111' && valorHaber5 == '11332'

//Verificamos los valores de la columna Concepto
WebUI.executeJavaScript('hot.selectCell(18, 10)', null)
def String datoConcepto1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 10)', null)
def String datoConcepto2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 10)', null)
def String datoConcepto3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 10)', null)
def String datoConcepto4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 10)', null)
def String datoConcepto5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 10)', null)
def String datoConcepto6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 10)', null)
def String datoConcepto7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 10)', null)
def String datoConcepto8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (datoConcepto1 == 'Cierre del ejercicio $' && datoConcepto2 == 'Cierre del ejercicio $' && datoConcepto3 == 'Cierre del ejercicio $' 
	 && datoConcepto4 == 'Cierre del ejercicio $' && datoConcepto5 == 'Cierre del ejercicio $' && datoConcepto6 == 'Cierre del ejercicio $' 
	 && datoConcepto7 == 'Cierre del ejercicio $' && datoConcepto8 == 'Cierre del ejercicio $')

//Verificamos los valores de la columna Moneda
WebUI.executeJavaScript('hot.selectCell(18, 11)', null)
def String datoMoneda1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 11)', null)
def String datoMoneda2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 11)', null)
def String datoMoneda3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 11)', null)
def String datoMoneda4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 11)', null)
def String datoMoneda5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 11)', null)
def String datoMoneda6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 11)', null)
def String datoMoneda7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 11)', null)
def String datoMoneda8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (datoMoneda1 == '0' && datoMoneda2 == '0' && datoMoneda3 == '0' && datoMoneda4 == '0' 
	&& datoMoneda5 == '0' && datoMoneda6 == '0' && datoMoneda7 == '0' && datoMoneda8 == '0')

//Verificamos los valores de la columna Total
WebUI.executeJavaScript('hot.selectCell(18, 12)', null)
def String valorTotal1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 12)', null)
def String valorTotal2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 12)', null)
def String valorTotal3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 12)', null)
def String valorTotal4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 12)', null)
def String valorTotal5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 12)', null)
def String valorTotal6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 12)', null)
def String valorTotal7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 12)', null)
def String valorTotal8 = WebUI.executeJavaScript('return hot.getValue()', null)

//Tomamos el valor solo con dos decimales, ya que los valores viene con muchos decimales 
valorTotal1 = valorTotal1.substring(0, 8)
valorTotal3 = valorTotal3.substring(0, 7)
valorTotal8 = valorTotal8.substring(0, 7)

assert (valorTotal1 == '43300.16' && valorTotal2 == '18500' && valorTotal3 == '2073.77' && valorTotal4 == '33000' 
	 && valorTotal5 == '20590' && valorTotal6 == '6120' && valorTotal7 == '2550' && valorTotal8 == '1613.93')

//Verificamos los valores de la columna Total N (impuestos)
WebUI.executeJavaScript('hot.selectCell(18, 13)', null)
def String codImpuesto1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 13)', null)
def String codImpuesto2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 13)', null)
def String codImpuesto3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 13)', null)
def String codImpuesto4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 13)', null)
def String codImpuesto5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 13)', null)
def String codImpuesto6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 13)', null)
def String codImpuesto7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 13)', null)
def String codImpuesto8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codImpuesto1 == '0' && codImpuesto2 == '0' && codImpuesto3 == '0' && codImpuesto4 == '0' 
	 && codImpuesto5 == '0' && codImpuesto6 == '0' && codImpuesto7 == '0' && codImpuesto8 == '0')

//Verificamos los valores de la columna IVA
WebUI.executeJavaScript('hot.selectCell(18, 14)', null)
def String valorIVA1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 14)', null)
def String valorIVA2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 14)', null)
def String valorIVA3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 14)', null)
def String valorIVA4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 14)', null)
def String valorIVA5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 14)', null)
def String valorIVA6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 14)', null)
def String valorIVA7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 14)', null)
def String valorIVA8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (valorIVA1 == '0' && valorIVA2 == '0' && valorIVA3 == '0' && valorIVA4 == '0' 
	 && valorIVA5 == '0' && valorIVA6 == '0' && valorIVA7 == '0' && valorIVA8 == '0')

//Verificamos los valores de la columna Cotizacion
WebUI.executeJavaScript('hot.selectCell(18, 18)', null)
def String valorCotizacion1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 18)', null)
def String valorCotizacion2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 18)', null)
def String valorCotizacion3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 18)', null)
def String valorCotizacion4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 18)', null)
def String valorCotizacion5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 18)', null)
def String valorCotizacion6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 18)', null)
def String valorCotizacion7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 18)', null)
def String valorCotizacion8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (valorCotizacion1 == '-1' && valorCotizacion2 == '-1' && valorCotizacion3 == '-1' 
	 && valorCotizacion4 == '-1' && valorCotizacion5 == '-1' && valorCotizacion6 == '-1' 
	 && valorCotizacion7 == '-1' && valorCotizacion8 == '-1')

//Verificamos los valores de la columna Libro (L)
WebUI.executeJavaScript('hot.selectCell(18, 19)', null)
def String codLibro1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 19)', null)
def String codLibro2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 19)', null)
def String codLibro3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 19)', null)
def String codLibro4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 19)', null)
def String codLibro5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 19)', null)
def String codLibro6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 19)', null)
def String codLibro7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 19)', null)
def String codLibro8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codLibro1 == 'U' && codLibro2 == 'U' && codLibro3 == 'U' && codLibro4 == 'U' 
	 && codLibro5 == 'U' && codLibro6 == 'U' && codLibro7 == 'U' && codLibro8 == 'U')

//Verificamos los valores de la columna Tipo
WebUI.executeJavaScript('hot.selectCell(18, 21)', null)
def String codTipo1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 21)', null)
def String codTipo2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 21)', null)
def String codTipo3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 21)', null)
def String codTipo4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 21)', null)
def String codTipo5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 21)', null)
def String codTipo6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 21)', null)
def String codTipo7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 21)', null)
def String codTipo8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codTipo1 == 'CIE' && codTipo2 == 'CIE' && codTipo3 == 'CIE' && codTipo4 == 'CIE' 
	 && codTipo5 == 'CIE' && codTipo6 == 'CIE' && codTipo7 == 'CIE' && codTipo8 == 'CIE')

//Verificamos los valores de la columna Origen
WebUI.executeJavaScript('hot.selectCell(18, 22)', null)
def String codOrigen1 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(19, 22)', null)
def String codOrigen2 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(20, 22)', null)
def String codOrigen3 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(21, 22)', null)
def String codOrigen4 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(22, 22)', null)
def String codOrigen5 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(23, 22)', null)
def String codOrigen6 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(24, 22)', null)
def String codOrigen7 = WebUI.executeJavaScript('return hot.getValue()', null)
WebUI.executeJavaScript('hot.selectCell(25, 22)', null)
def String codOrigen8 = WebUI.executeJavaScript('return hot.getValue()', null)

assert (codOrigen1 == 'CI' && codOrigen2 == 'CI' && codOrigen3 == 'CI' && codOrigen4 == 'CI' 
	 && codOrigen5 == 'CI' && codOrigen6 == 'CI' && codOrigen7 == 'CI' && codOrigen8 == 'CI')

//Nos vamos a la opcion Asientos
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.verifyTextPresent('2/2022', false)
WebUI.verifyTextPresent('3/2022', false)

