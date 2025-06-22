class FoodRatings {

    private Map<String, Pair<String, Integer>> cuisineRatingByFood;
    private Map<String, SortedSet<String>> foodByCuisine;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        final var n = foods.length;
        this.cuisineRatingByFood = new HashMap<>(n);
        this.foodByCuisine = new HashMap<>();
        populateMaps(foods, cuisines, ratings);
    }

    public void changeRating(String food, int newRating) {
        final var cuisine = cuisineRatingByFood.get(food).getKey();
        final var foodInCuisine = foodByCuisine.get(cuisine);
        foodInCuisine.remove(food);
        cuisineRatingByFood.put(food, new Pair<>(cuisine, newRating));
        foodInCuisine.add(food);
    }

    public String highestRated(String cuisine) {
        return foodByCuisine.get(cuisine).last();
    }

    private void populateMaps(
        String[] foods,
        String[] cuisines,
        int[] ratings
    ) {
        final var n = foods.length;
        for (var i = 0; i < n; ++i) {
            final var food = foods[i];
            final var cuisine = cuisines[i];
            final var rating = ratings[i];
            cuisineRatingByFood.put(food, new Pair<>(cuisine, rating));
            foodByCuisine
                .computeIfAbsent(cuisine, k ->
                    new TreeSet<>((a, b) -> {
                        final var pa = cuisineRatingByFood.get(a);
                        final var pb = cuisineRatingByFood.get(b);
                        final var byRating = pa.getValue() - pb.getValue();
                        if (byRating != 0) return byRating;
                        return b.compareTo(a);
                    })
                )
                .add(food);
        }
    }
}
