/**
 * Created by Andrew on 17.04.2016.
 */

var cartApp = angular.module("cartApp", []);
cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function () {
        $http.get('/cart/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function() {
        $http.delete('/cart/rest/cart/' + $scope.cartId)
            .success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId) {
    	alert("\n***** Selected productId for addToCart = "+productId);
        $http.post('/cart/rest/cart/add/'+ productId).success(function () {
        	alert("Adding "+productId);
            $scope.refreshCart();
        });
    };

    $scope.removeFromCart = function(cartItemId) {
    	alert("removing item "+cartItemId);
        $http.post('/cart/rest/cart/remove/' + cartItemId).success(function (data) {
        	
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});

