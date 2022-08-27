package controller;

import model.Group;

public class ControlExpense {
	private Group group;
	private Double value;

	public ControlExpense() {
		this.value = group.getValue();
	}

	public void createExpense() {
		if (value == null) {
			System.out.println("Preencha todos os campos");
		} else {
			group.setValue(value);
			System.out.println("Despesa cadastrada com sucesso");
		}
	}

}
