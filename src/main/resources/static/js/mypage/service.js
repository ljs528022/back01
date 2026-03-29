const service = (() => {
    const writeProduct = async (formData) => {
        const response = await fetch("/api/mypage/products", {
            method: "POST",
            body: formData
        });

        const text = await response.text();

        if (!response.ok) {
            throw new Error(text || "Fetch error");
        }

        return text ? JSON.parse(text) : {};
    };

    // 내 상품 목록은 기존 프로젝트의 다른 목록 조회와 같은 방식으로
    // page 파라미터를 받고, 필요하면 callback에 결과를 넘겨준다.
    const getMyProducts = async (page, callback) => {
        const response = await fetch(`/api/mypage/products?page=${page}`);
        const data = await response.json();

        if (callback) return callback(data);
        return data;
    };

    return {
        writeProduct: writeProduct,
        getMyProducts: getMyProducts
    };
})();
