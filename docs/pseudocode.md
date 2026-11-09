==================================================
PROJECT 3: THE KNAPSACK PROBLEM
==================================================

CLASS Experiment

    DECLARE name
    DECLARE weight
    DECLARE rating

    CONSTRUCTOR Experiment(name, weight, rating)
        STORE name
        STORE weight
        STORE rating
    END CONSTRUCTOR

    METHOD getName()
        RETURN name
    END METHOD

    METHOD getWeight()
        RETURN weight
    END METHOD

    METHOD getRating()
        RETURN rating
    END METHOD

END CLASS

==================================================
CLASS Results
==================================================

    DECLARE selected as List of Experiment
    DECLARE totalWeight
    DECLARE totalRating

    CONSTRUCTOR Results(selected, totalWeight, totalRating)
        STORE selected experiments
        STORE total weight
        STORE total rating
    END CONSTRUCTOR

    METHOD getSelected()
        RETURN selected
    END METHOD

    METHOD getTotalWeight()
        RETURN totalWeight
    END METHOD

    METHOD getTotalRating()
        RETURN totalRating
    END METHOD

END CLASS

==================================================
CLASS Main
==================================================

    SET capacity = 700

    METHOD loadExperiments()

        CREATE empty list of experiments

        ADD Experiment("Cloud Patterns", 36, 5)
        ADD Experiment("Solar Flares", 264, 9)
        ADD Experiment("Solar Power", 188, 6)
        ADD Experiment("Binary Stars", 203, 8)
        ADD Experiment("Relativity", 104, 8)
        ADD Experiment("Seed Viability", 7, 4)
        ADD Experiment("Sun Spots", 90, 2)
        ADD Experiment("Mice Tumors", 65, 8)
        ADD Experiment("Microgravity Plant Growth", 75, 5)
        ADD Experiment("Micrometeorites", 170, 9)
        ADD Experiment("Cosmic Rays", 80, 7)
        ADD Experiment("Yeast Fermentation", 27, 4)

        RETURN experiments

    END METHOD


    METHOD main()

        experiments = loadExperiments()

        // Run greedy strategies

        highestRating =
            GreedyStrategies.highestRatingFirst(
                experiments, capacity)

        lightest =
            GreedyStrategies.lightestRatingFirst(
                experiments, capacity)

        bestRatio =
            GreedyStrategies.ratingToWeightRatio(
                experiments, capacity)

        // Run brute force

        bruteForceResults =
            BruteForce.topThree(experiments, capacity)

        // Display results

        DISPLAY highestRating
        DISPLAY lightest
        DISPLAY bestRatio
        DISPLAY top three brute-force results

        // Compare greedy strategies against optimal result

        SET optimal = first result from bruteForceResults

        COMPARE each greedy result's total rating
            against optimal total rating

        IDENTIFY which greedy strategies matched optimal

        DISPLAY comparison summary

    END METHOD

END CLASS


==================================================
CLASS GreedyStrategies
==================================================

METHOD highestRatingFirst(experiments, capacity)

    SET totalWeight = 0
    SET totalRating = 0
    CREATE empty selected list

    SORT a copy of experiments by rating
        from highest to lowest

    FOR EACH experiment

        IF totalWeight + experiment.weight <= capacity

            ADD experiment to selected
            totalWeight = totalWeight + experiment.weight
            totalRating = totalRating + experiment.rating

        END IF

    END FOR

    RETURN Results(selected, totalWeight, totalRating)

END METHOD


METHOD lightestRatingFirst(experiments, capacity)

    SET totalWeight = 0
    SET totalRating = 0
    CREATE empty selected list

    SORT a copy of experiments by weight
        from lowest to highest

    FOR EACH experiment

        IF totalWeight + experiment.weight <= capacity

            ADD experiment to selected
            totalWeight = totalWeight + experiment.weight
            totalRating = totalRating + experiment.rating

        END IF

    END FOR

    RETURN Results(selected, totalWeight, totalRating)

END METHOD


METHOD ratingToWeightRatio(experiments, capacity)

    SET totalWeight = 0
    SET totalRating = 0
    CREATE empty selected list

    FOR EACH experiment

        CALCULATE ratio =
            experiment.rating / experiment.weight

    END FOR

    SORT a copy of experiments by ratio
        from highest to lowest

    FOR EACH experiment

        IF totalWeight + experiment.weight <= capacity

            ADD experiment to selected
            totalWeight = totalWeight + experiment.weight
            totalRating = totalRating + experiment.rating

        END IF

    END FOR

    RETURN Results(selected, totalWeight, totalRating)

END METHOD

END CLASS

==================================================
CLASS BruteForce
==================================================

METHOD topThree(experiments, capacity)

    SET numberOfExperiments = size of experiments

    SET numberOfSubsets = 2 raised to
        numberOfExperiments

    CREATE empty list called topThreeResults

    FOR subsetNumber = 0 TO numberOfSubsets - 1

        SET totalWeight = 0
        SET totalRating = 0
        CREATE empty selected list

        FOR index = 0 TO numberOfExperiments - 1

            CHECK whether bit at index is 1
                in subsetNumber

            IF bit is 1

                GET experiment at index

                ADD experiment to selected
                ADD experiment.weight to totalWeight
                ADD experiment.rating to totalRating

            END IF

        END FOR

        IF totalWeight <= capacity

            CREATE Results object with:
                selected
                totalWeight
                totalRating

            ADD Results object to topThreeResults

            SORT topThreeResults by totalRating
                from highest to lowest

            IF size of topThreeResults > 3
                REMOVE the lowest-rated result
            END IF

        END IF

    END FOR

    RETURN topThreeResults

END METHOD

END CLASS

