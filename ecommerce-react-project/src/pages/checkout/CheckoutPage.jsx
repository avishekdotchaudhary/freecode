import "./CheckoutPage.css";
import { Header } from "../../components/Header";
import { useEffect, useState } from "react";
import axios from "axios";
import { OrderSummary } from "./OrderSummary";
import { PaymentSymmary } from "./PaymentSummary";

export const CheckoutPage = ({ cart }) => {
  const [deliveryOptions, setDeliveryOptions] = useState([]);
  const [paymentSummary, setPaymentSummary] = useState(null);

  useEffect(() => {
    const fetchCheckoutData = async () => {
      let response = await axios.get(
        "/api/delivery-options?expand=estimatedDeliveryTime",
      );
      setDeliveryOptions(response.data);

      response = await axios.get("/api/payment-summary");
      setPaymentSummary(response.data);
    };

    fetchCheckoutData();
  }, []);

  return (
    <>
      <title>Checkout</title>
      <Header cart={cart} />

      <div className="checkout-page">
        <div className="page-title">Review your order</div>

        <div className="checkout-grid">
          <OrderSummary cart={cart} deliveryOptions={deliveryOptions} />

          <PaymentSymmary paymentSummary={paymentSummary} />
        </div>
      </div>
    </>
  );
};
