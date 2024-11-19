function addProduct() {
    const select = document.getElementById('products');
    const selectedOption = select.options[select.selectedIndex];
    const productId = selectedOption.value;
    const productName = selectedOption.text;

    const quantity = prompt(`Digite a quantidade para o produto: ${productName}`);

    if (quantity !== null && quantity !== '') {
        const selectedProductsList = document.getElementById('selectedProductsList');
        const listItem = document.createElement('li');
        listItem.textContent = `${productName} - Quantidade: ${quantity}`;
        listItem.dataset.productId = productId;
        listItem.dataset.quantity = quantity;
        selectedProductsList.appendChild(listItem);

        alert(`Produto ${productName} com quantidade ${quantity} adicionado.`);
    }
}

function removeProduct(event) {
    if (event.target.tagName === 'LI') {
        const listItem = event.target;
        const productName = listItem.textContent.split(' - ')[0];
        if (confirm(`Deseja remover o produto ${productName}?`)) {
            listItem.remove();
        }
    }
}

function prepareSelectedProducts() {
    const selectedProductsList = document.getElementById('selectedProductsList');
    const selectedProducts = [];
    selectedProductsList.querySelectorAll('li').forEach(item => {
        selectedProducts.push({
            productId: item.dataset.productId,
            quantity: item.dataset.quantity
        });
    });
    document.getElementById('selectedProducts').value = JSON.stringify(selectedProducts);
}