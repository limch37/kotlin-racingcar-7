package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Racetrack {
    private val cars: MutableList<Car> = mutableListOf() // 경기 중인 자동차
    private var attemptCount: Int = 0 // 경기 이동 횟수

    // 리스트에 자동차 추가
    fun addCar(car: Car) {
        cars.add(car)
    }

    // 경기 이동 횟수 설정
    fun setAttemptCount(count: Int) {
        attemptCount = count
    }

    // 경기 시작
    fun startRace() {
        repeat(attemptCount) {
            raceOnce()  // 한 번의 경주 진행
            printRaceStatus()  // 현재 상태 출력
        }
        printWinners()  // 경기 종료 후, 우승자 출력
        clearCars()  // 경기 종료 후, 자동차 리스트 초기화
    }

    // 차수마다 경주를 진행
    private fun raceOnce() {
        cars.forEach { car ->
            val randomValue = Randoms.pickNumberInRange(0, 9)  // 0과 9 사이의 무작위 값
            car.moveFoward(randomValue)
        }
    }

    // 현재 상태 출력
    private fun printRaceStatus() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println("\n")
    }

    // 우승자 출력
    private fun printWinners() {
        val maxPosition = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxPosition }
        println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
    }

    // 자동차 초기화
    private fun clearCars() {
        cars.clear()
    }
}