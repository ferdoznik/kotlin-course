package lessons.lesson5.homeworks

class ElvisOperator {

    fun main() {
        // Задача 1
        val initialIntensity: Double = 120.0
        val attenuationCoeff: Double? = null
        val effectiveCoeff = attenuationCoeff ?: 0.5
        val attenuatedIntensity = initialIntensity * effectiveCoeff

        // Задача 2
        val deliveryCost: Double = 18.99
        val cargoValue: Double? = null
        val effectiveCargoValue = cargoValue ?: 50.0
        val insurance = effectiveCargoValue * 0.005
        val totalDeliveryCost = deliveryCost + insurance

        // Задача 3
        val pressure: String? = null
        val attentionMessage = "Error! Pressure is low"
        val pressureForLab = pressure ?: attentionMessage
    }
}